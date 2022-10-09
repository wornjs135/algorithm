package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] dp = new int[n][];
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			dp[i] = new int[i+1];
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}			
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(j == 0) {
					dp[i][j] += dp[i-1][0];
				} else if (j == dp[i].length-1) {
					dp[i][j] += dp[i-1][dp[i-1].length-1];
				} else {
					dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < dp[n-1][i]) {
				max = dp[n-1][i];
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		in.close();
	}

	static String str = "5\r\n" + 
			"7\r\n" + 
			"3 8\r\n" + 
			"8 1 0\r\n" + 
			"2 7 4 4\r\n" + 
			"4 5 2 6 5";
	
}
