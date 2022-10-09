package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_D4_1249_보급로 {
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int time;
		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
		
	}
	
	static int N;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();	
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j] - '0';
				}
			}
			
			int result = bfs(map, 0, 0, new boolean[N][N]);
			
			sb.append(result).append("\n");
		}		
		System.out.println(sb);
		in.close();
	}
	private static int bfs(int[][] map, int startR, int startC, boolean[][] visited) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(startR, startC, map[startR][startC]));
		visited[startR][startC] = true;
		while(!pq.isEmpty()) {
			Point curr = pq.poll();
			if(curr.r == N-1 && curr.c == N-1) {
				return curr.time;
			}
			for (int k = 0; k < 4; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];
				if(isValid(nr, nc) && !visited[nr][nc]) {
					pq.add(new Point(nr, nc, curr.time + map[nr][nc]));
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}
	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	static String str =	"2\r\n" + 
			"4\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1011\r\n" + 
			"1010\r\n" + 
			"6\r\n" + 
			"011001\r\n" + 
			"010100\r\n" + 
			"010011\r\n" + 
			"101001\r\n" + 
			"010101\r\n" + 
			"111010";
}
