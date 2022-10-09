package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1987_알파벳 {
	static int R, C;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static char[][] board;
	static boolean[] isUsed = new boolean[26];
	static int max = Integer.MIN_VALUE;

	private static void move(int r, int c, int count) {

		isUsed[board[r][c] - 'A'] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (isValid(nr, nc) && !isUsed[board[nr][nc] - 'A']) {
				move(nr, nc, count + 1);
			}
		}
		if (max < count) {
			max = count;
		}
		isUsed[board[r][c] - 'A'] = false;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];

		for (int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}

		move(0, 0, 1);

		sb.append(max);
		System.out.println(sb);
		in.close();
	}

//	static String str = "5 5\r\n" + 
//			"IEFCJ\r\n" + 
//			"FHFKC\r\n" + 
//			"FFALF\r\n" + 
//			"HFGCF\r\n" + 
//			"HMCHH";
}
