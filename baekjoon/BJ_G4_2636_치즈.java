package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2636_치즈 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int N;
	static int M;
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
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
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int hour = 0;
		int lastCount = 0;
		int cnt = 0;
		while((cnt = bfs(map)) != 0) {
			lastCount = cnt;
			hour++;
		}
		
		sb.append(hour).append("\n");
		sb.append(lastCount);
		System.out.println(sb);
		in.close();
	}

	private static int bfs(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		int delete = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];
				if(isValid(nr, nc) && !visited[nr][nc]) {
					if (map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc));
					} else {
						map[nr][nc] = 0;
						visited[nr][nc] = true;
						delete++;
					}
				}
			}
		}
		return delete;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static String str = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
	
}
