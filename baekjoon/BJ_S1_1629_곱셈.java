package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BJ_S1_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		BigDecimal bigC = BigDecimal.valueOf(C);
		long startA = A;
		BigDecimal result = null;
		long temp = 0;
		int cnt = 0;
		if (B == 1)
			result = BigDecimal.valueOf(A % C);
		else {
			while (B != 1) {
				if (B % 2 == 0) {
					A = (long) Math.pow(A, 2);
					B = B / 2;
				} else {
					B -= 1;
					A = (long) Math.pow(A, 2);
					B = B / 2;
					cnt++;
				}
			}
			BigDecimal big = BigDecimal.valueOf(A * (long)Math.pow(startA, cnt));
			result = big.remainder(bigC);
		}

		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	static String str = "2 222 41";

}
