package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_4485_녹색옷입은애 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N;
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int money;
		
		public Point(int r, int c, int money) {
			super();
			this.r = r;
			this.c = c;
			this.money = money;
		}

		@Override
		public int compareTo(Point o) {
			return this.money - o.money;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		int tc = 1;
		while (N != 0) {
			sb.append("Problem " + tc + ": ");
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = bfs(map);
			
			sb.append(result).append("\n");
			tc++;
			N = Integer.parseInt(in.readLine());
		}

		System.out.println(sb);
		in.close();
	}

	private static int bfs(int[][] map) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));
		while(!pq.isEmpty()) {
			Point curr = pq.poll();
			if(curr.r == N-1 && curr.c == N-1) {
				return curr.money;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(isValid(nr, nc) && map[nr][nc] != -1) {
					pq.offer(new Point(nr, nc, curr.money + map[nr][nc]));
					map[nr][nc] = -1;
				}
			}
		}
		return 0;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static String str = "3\r\n" + "5 5 4\r\n" + "3 9 1\r\n" + "3 2 7\r\n" + "5\r\n" + "3 7 2 0 1\r\n" + "2 8 0 9 1\r\n"
			+ "1 2 1 8 1\r\n" + "9 8 9 2 0\r\n" + "3 6 5 1 5\r\n" + "7\r\n" + "9 0 5 1 1 5 3\r\n" + "4 1 2 1 6 5 3\r\n"
			+ "0 7 6 1 6 8 5\r\n" + "1 1 7 8 3 2 3\r\n" + "9 4 0 7 6 4 1\r\n" + "5 8 3 2 4 8 3\r\n"
			+ "7 4 8 4 8 3 4\r\n" + "0";

}
