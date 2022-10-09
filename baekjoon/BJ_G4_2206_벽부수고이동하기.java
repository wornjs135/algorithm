package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2206_벽부수고이동하기 {
	
	static class Point {
		int r;
		int c;
		int breakWall;
		int moveCnt;
		public Point(int r, int c, int breakWall, int moveCnt) {
			super();
			this.r = r;
			this.c = c;
			this.breakWall = breakWall;
			this.moveCnt = moveCnt;
		}
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			map[i] = s.toCharArray();
		}
		
		int cnt = bfs(map, new boolean[2][N][M]);
		
		sb.append(cnt);
		System.out.println(sb);
		in.close();
	}
	
	private static int bfs(char[][] map, boolean[][][] visited) {
		visited[0][0][0] = true;
		Point start = new Point(0, 0, 0, 1);
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			Point curr = q.poll();
			if(curr.r == N-1 && curr.c == M-1) return curr.moveCnt;
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(!isValid(nr, nc)) continue;
				if(visited[curr.breakWall][nr][nc]) continue;
				if (curr.breakWall == 0) { // 벽을 안뿌셨을 경우
					if(map[nr][nc] == '0') {
						visited[0][nr][nc] = true;
						q.offer(new Point(nr, nc, 0, curr.moveCnt+1));
					} else {
						visited[1][nr][nc] = true;
						q.offer(new Point(nr, nc, 1, curr.moveCnt+1));
					}
				} else { // 벽을 뿌셨을 경우
					if(map[nr][nc] == '1') continue;
					visited[1][nr][nc] = true;
					q.offer(new Point(nr, nc, 1, curr.moveCnt+1));
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static String str = "5 5\r\n" + 
			"00000\r\n" + 
			"00000\r\n" + 
			"00000\r\n" + 
			"00000\r\n" + 
			"00000";
}
