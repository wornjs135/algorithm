package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B1_2563_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		boolean[][] paper = new boolean[100][100];

		int N = Integer.parseInt(in.readLine());

		int[][] black = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] s = in.readLine().split(" ");
			black[i][0] = Integer.parseInt(s[0]);
			black[i][1] = Integer.parseInt(s[1]);

			for (int r = 99 - black[i][1]; r > 99 - black[i][1] - 10; r--) {
				for (int c = black[i][0]; c < black[i][0] + 10; c++) {
					paper[r][c] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j]) {
					count++;
				}
			}
		}
		
		sb.append(count);
		System.out.println(sb);
	}

//	static String str = "3\r\n" + "3 7\r\n" + "15 7\r\n" + "5 2";
}
