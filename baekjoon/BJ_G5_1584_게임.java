package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1584_게임 {

	static int N;
	static int M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int hp;

		public Point(int r, int c, int hp) {
			super();
			this.r = r;
			this.c = c;
			this.hp = hp;
		}

		@Override
		public int compareTo(Point o) {
			return this.hp - o.hp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] map = new int[501][501];

		N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			for (int j = Math.min(r1, r2); j <= (Math.max(r2, r1)); j++) {
				for (int k = Math.min(c1, c2); k <= (Math.max(c2, c1)); k++) {
					map[j][k] = 1;
				}
			}
		}

		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			for (int j = Math.min(r1, r2); j <= (Math.max(r2, r1)); j++) {
				for (int k = Math.min(c1, c2); k <= (Math.max(c2, c1)); k++) {
					map[j][k] = -1;
				}
			}
		}

		System.out.println(bfs(map));

		in.close();
	}

	private static int bfs(int[][] map) {
		map[0][0] = 0;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] isVisited = new boolean[501][501];
		Point curr = new Point(0, 0, 0);
		isVisited[0][0] = true;
		pq.add(curr);
		while (!pq.isEmpty()) {
			Point temp = pq.poll();

			if (temp.r == 500 && temp.c == 500) {
				return temp.hp;
			}

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if (isValid(nr, nc) && map[nr][nc] != -1 && (!isVisited[nr][nc])) {
					map[nr][nc] += temp.hp;
					pq.add(new Point(nr, nc, map[nr][nc]));
					isVisited[temp.r][temp.c] = true;

				}
			}

		}

		return -1;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < 501 && nc >= 0 && nc < 501;
	}
}

