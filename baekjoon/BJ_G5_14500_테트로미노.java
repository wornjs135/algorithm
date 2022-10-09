package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_14500_테트로미노 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int N, M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(map, new boolean[N][M], 1, i, j, map[i][j]);
				System.out.println("##############################################################################################################");
			}
		}

		sb.append(max);
		System.out.println(sb);
		in.close();
	}

	private static void dfs(int[][] map, boolean[][] visited, int cnt, int currR, int currC, int sum) {
		if (cnt == 4) {
			if (max < sum) {
				max = sum;
			}
//			for (int i = 0; i < visited.length; i++) {
//				for (int j = 0; j < visited.length; j++) {
//					System.out.print(visited[i][j] ? 'o' : 'x');
//				}
//				System.out.println();
//			}
//			System.out.println("--------------------------------------------");
			return;
		}

		visited[currR][currC] = true;
		System.out.println(visited[currR][currC]?"찍음": "안찍음");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] ? 'o' : 'x');
			}
			System.out.println();
		}
		for (int k = 0; k < 4; k++) {
			int nr = currR + dr[k];
			int nc = currC + dc[k];
			if (isValid(nr, nc) && !visited[nr][nc]) {
				dfs(map, visited, cnt + 1, nr, nc, sum + map[nr][nc]);
			}
		}
		visited[currR][currC] = false;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static String str = "4 10\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1"
			;
}
