package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {

	static int N;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];

		int maxRain = 0;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (maxRain < map[i][j]) {
					maxRain = map[i][j];
				}
			}
		}

		for (int i = 0; i <= maxRain; i++) {
			int rain = i;
			boolean[][] isFlooded = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] <= rain) {
						isFlooded[r][c] = true;
					}
				}
			}
			
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(isFlooded[r][c] ? "X" : map[r][c]);
//				}
//				System.out.println();
//			}

			int cnt = 0;
			boolean[][] isVisited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!isFlooded[r][c] && !isVisited[r][c]) {
						dfs(map, isFlooded, isVisited, r, c);
						cnt++;
					}
				}
			}
			if(MAX < cnt) {
				MAX = cnt;
			}
//			System.out.println(i + " " + cnt);
		}
		
		sb.append(MAX);
		System.out.println(sb);

		in.close();
	}

	private static void dfs(int[][] map, boolean[][] isFlooded, boolean[][] isVisited, int currR, int currC) {

		isVisited[currR][currC] = true;
		for (int k = 0; k < 4; k++) {
			int nr = currR + dr[k];
			int nc = currC + dc[k];
			if (isValid(nr, nc) && !isFlooded[nr][nc] && !isVisited[nr][nc]) {
				dfs(map, isFlooded, isVisited, nr, nc);
			}
		}

	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static String str = "5\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1";

}
