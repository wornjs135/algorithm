package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2638_치즈 {
	
	static class Point {
		int r;
		int c;
		int airCnt;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.airCnt = 0;
		}
		
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	static int N, M;

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
		
		int time = 0;
		while(bfs(map, 0, 0) != 0) {
			time++;
		}
		
		sb.append(time);
		System.out.println(sb);
		in.close();
	}
	private static int bfs(int[][] map, int startR, int startC) {
		int delete = 0;
		boolean[][] visited = new boolean[N][M];
		boolean[][] cheeseAir = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startR, startC));
		visited[startR][startC] = true;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(!isValid(nr, nc)) continue;
				if(map[nr][nc] == 0) {
					if(!visited[nr][nc]) {
						q.add(new Point(nr, nc));
						visited[nr][nc] = true;
					}
				} else if (map[nr][nc] == 1) {
					if(cheeseAir[nr][nc]) {
						map[nr][nc] = 0;
						visited[nr][nc] = true;
						delete++;
					} else {
						cheeseAir[nr][nc] = true;
					}
				}
			}
		}
		
		return delete;
	}
	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 & nc < M;
	}
	static String str = "8 9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 1 1 0 1 1 0\r\n" + 
			"0 0 1 1 1 1 1 1 0\r\n" + 
			"0 0 1 1 1 1 1 0 0\r\n" + 
			"0 0 1 1 0 1 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0";
}
