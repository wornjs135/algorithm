package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_G5_9663_NQueen {
	
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] column = new int[N+1];
		
		dfs(1, column, N);
		
		sb.append(result);
		System.out.println(sb);
		in.close();
	}
	private static void dfs(int row, int[] column, int N) {
		if(!isAvailable(row-1, column)) {
			return;
		}
		
		if(row > N) {
			result++;
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			column[row] = i;
			dfs(row+1, column, N);
		}
	}
	private static boolean isAvailable(int row, int[] column) {
		
		for (int i = 1; i < row; i++) {
			if(column[i] == column[row] || row - i == Math.abs(column[row] - column[i]))
				return false;
		}
		
		return true;
	}
	static String str = "8";
}
