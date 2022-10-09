package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {

	static int N, M;
	static int max;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		List<Point> virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		max = 0;

		dfs(map, virus, 0, 3);

		sb.append(max);
		System.out.println(sb);
		in.readLine();
	}

	private static void dfs(int[][] map, List<Point> virus, int wallCnt, int maxWall) {
		if (wallCnt == maxWall) {
			int[][] newMap = new int[N][M];
			mapCopy(newMap, map);
			Queue<Point> q = new LinkedList<>();
			for (Point point : virus) {
				q.offer(point);
			}
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (isValid(nr, nc) && newMap[nr][nc] == 0) {
						q.offer(new Point(nr, nc));
						newMap[nr][nc] = 2;
					}
				}
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (newMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			if (max < cnt) {
				max = cnt;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(map, virus, wallCnt+1, 3);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void mapCopy(int[][] newMap, int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	// dfs로 벽세우기
	// 3개 다 세우면
	// 그 안에서 bfs로 바이러스 확산 원래 맵은 유지해야할듯
	// 안전영역 세서 max에 저장

	static String str = "7 7\r\n" + "2 0 0 0 1 1 0\r\n" + "0 0 1 0 1 2 0\r\n" + "0 1 1 0 1 0 0\r\n"
			+ "0 1 0 0 0 0 0\r\n" + "0 0 0 0 0 1 1\r\n" + "0 1 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0";
}
