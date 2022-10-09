package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14503_로봇청소기 {

	static class Point {
		int r;
		int c;
		int d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d; // 북0 동1 남2 서3
		}

	}

	static int N, M;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		st = new StringTokenizer(in.readLine());
		Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] cleaned = new boolean[N][M];
		bfs(map, cleaned, start);
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cleaned[i][j]) {
					result++;
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	private static void bfs(int[][] map, boolean[][] cleaned, Point start) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		cleaned[start.r][start.c] = true;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				if(curr.d == 0) {
					int nr = curr.r;
					int nc = curr.c - 1;
					curr.d = 3;
					if(isValid(nr, nc) && map[nr][nc] == 0 && !cleaned[nr][nc]) {
						q.offer(new Point(nr, nc, curr.d));
						cleaned[nr][nc] = true;
						flag = true;
						break;
					}
				} else if (curr.d == 1) {
					int nr = curr.r - 1;
					int nc = curr.c;
					curr.d = 0;
					if(isValid(nr, nc) && map[nr][nc] == 0 && !cleaned[nr][nc]) {
						q.offer(new Point(nr, nc, curr.d));
						cleaned[nr][nc] = true;
						flag = true;
						break;
					}
				} else if (curr.d == 2) {
					int nr = curr.r;
					int nc = curr.c + 1;
					curr.d = 1;
					if(isValid(nr, nc) && map[nr][nc] == 0 && !cleaned[nr][nc]) {
						q.offer(new Point(nr, nc, curr.d));
						cleaned[nr][nc] = true;
						flag = true;
						break;
					}
				} else if (curr.d == 3) {
					int nr = curr.r + 1;
					int nc = curr.c;
					curr.d = 2;
					if(isValid(nr, nc) && map[nr][nc] == 0 && !cleaned[nr][nc]) {
						q.offer(new Point(nr, nc, curr.d));
						cleaned[nr][nc] = true;
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				if(curr.d == 0) {
					int nr = curr.r + 1;
					int nc = curr.c;
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						q.offer(new Point(nr, nc, curr.d));
					} else if (isValid(nr, nc) && map[nr][nc] == 1){
						break;
					}
				} else if (curr.d == 1) {
					int nr = curr.r;
					int nc = curr.c - 1;
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						q.offer(new Point(nr, nc, curr.d));
					} else if (isValid(nr, nc) && map[nr][nc] == 1){
						break;
					}
				} else if (curr.d == 2) {
					int nr = curr.r - 1;
					int nc = curr.c;
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						q.offer(new Point(nr, nc, curr.d));
					} else if (isValid(nr, nc) && map[nr][nc] == 1){
						break;
					}
				} else if (curr.d == 3) {
					int nr = curr.r;
					int nc = curr.c + 1;
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						q.offer(new Point(nr, nc, curr.d));
					} else if (isValid(nr, nc) && map[nr][nc] == 1){
						break;
					}
				}
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static String str = "6 7\r\n" + 
			"2 1 0\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 0 0 1\r\n" + 
			"1 0 1 0 1 0 1\r\n" + 
			"1 1 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 1\r\n" + 
			"1 1 1 1 1 1 1";
}
