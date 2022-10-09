package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SW_D3_6026_성수의비밀번호공격 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken()); // 공역 개수
			int N = Integer.parseInt(st.nextToken()); // 정의역 개수

			if(N==1) {
				sb.append(1).append("\n");
			} else {
				BigInteger[][] dp1 = new BigInteger[M+1][];

				// nCr 계산
				for (int i = 1; i < M + 1; i++) {
					dp1[i] = new BigInteger[i + 1];

					if (i == 1) {
						dp1[i][0] = new BigInteger("1");
						dp1[i][1] = new BigInteger("1");
					}

					for (int j = 0; j < dp1[i].length; j++) {
						if (j == 0 || j == dp1[i].length - 1) {
							dp1[i][j] = new BigInteger("1");
						} else {
							dp1[i][j] = dp1[i - 1][j - 1].add(dp1[i - 1][j]);
						}
					}
				}
				
				// 전사함수 개수 계산
				BigInteger result = new BigInteger("0");
				for (int i = 0; i <= M; i++) {
					result = result.add(dp1[M][i].multiply(BigInteger.valueOf((long) Math.pow((M-i),N) == 0 ? 1 : (long) Math.pow((M-i),N))).multiply(BigInteger.valueOf(i % 2 == 0 ? 1 : -1)));
					System.out.println(dp1[M][i] + " " +  (Math.pow((M-i),N) == 0 ? 1 :  Math.pow((M-i),N)) + " " + (i % 2 == 0 ? 1 : -1));
				}
				result = result.mod(new BigInteger("1000000007"));
				sb.append(result).append("\n");
			}
		}

		System.out.println(sb);
		in.close();
	}

	static String str = 
			"3\r\n" +
			"1 1\r\n" + 
			"2 5\r\n" + 
			"7 11";

}
