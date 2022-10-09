package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S3_2407_조합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();	
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
//		long[][] dp = new long[n+1][];
		BigInteger[][] dp1 = new BigInteger[n+1][];
		
		for (int i = 1; i < n+1; i++) {
//			dp[i] = new long[i+1];
			dp1[i] = new BigInteger[i+1];
			
			if(i == 1) {
//				dp[i][0] = 1;
//				dp[i][1] = 1;
				dp1[i][0] = new BigInteger("1");
				dp1[i][1] = new BigInteger("1");
			}
//			for (int j = 0; j < dp[i].length; j++) {
//				if(j == 0 || j == dp[i].length-1) {
//					dp[i][j] = 1;
//				} else {
//					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//				}
//			}
			for (int j = 0; j < dp1[i].length; j++) {
				if(j == 0 || j == dp1[i].length-1) {
					dp1[i][j] = new BigInteger("1");
				} else {
					dp1[i][j] = dp1[i-1][j-1].add(dp1[i-1][j]);
				}
			}
		}
		
		sb.append(dp1[n][m]);
		System.out.println(sb);
		in.close();
	}
	
	static String str = "5 5";

}
