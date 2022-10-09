package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S3_1463_1로만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if (i % 3 == 0 && min > dp[i / 3] + 1)
				min = dp[i / 3] + 1;
			if (i % 2 == 0 && min > dp[i / 2] + 1)
				min = dp[i / 2] + 1;
			if (min > dp[i - 1] + 1)
				min = dp[i - 1] + 1;
			dp[i] = min;
		}

		sb.append(dp[N]);
		System.out.println(sb);
		in.close();
	}

	static String str = "10";
}
