package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다가자 {
	
	static class Point {
		int r;
		int c;
		int flag;
		int moveCnt;
		public Point(int r, int c, int flag, int moveCnt) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.moveCnt = moveCnt;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int startR = 0;
		int startC = 0;
		
		for (int i = 0; i < N; i++) {
			String t = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j] == '0') {
					startR = i;
					startC = j;
				}
			}
		}
		
		int result = bfs(map, startR, startC, N, M);
		sb.append(result);
		System.out.println(sb);
		in.close();
	}
	
	private static int bfs(char[][] map, int startR, int startC, int N, int M) {
		boolean[][][] visited = new boolean[(int) Math.pow(2, 6)][N][M];
		Queue<Point> q = new LinkedList<>();
		visited[0][startR][startC] = true;
		map[startR][startC] = '.';
		q.offer(new Point(startR, startC, 0, 0));
		while(!q.isEmpty()) {
			Point curr = q.poll();
			if(map[curr.r][curr.c] == '1') { 
				return curr.moveCnt;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(!isValid(nr, nc, N, M)) continue;
				if(map[nr][nc] == '#') continue;
				if(visited[curr.flag][nr][nc]) continue;
				if(map[nr][nc] == '.') {
					visited[curr.flag][nr][nc] = true;
					q.offer(new Point(nr, nc, curr.flag, curr.moveCnt+1));
				} else if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
					int tempFlag = curr.flag | (1 << (map[nr][nc] - 'a'));
					visited[tempFlag][nr][nc] = true;
					q.offer(new Point(nr, nc, tempFlag, curr.moveCnt+1));
				} else if ('A' <= map[nr][nc] && map[nr][nc] <= 'F'){
					if((curr.flag & (1 << (map[nr][nc] - 'A'))) != 0) {
						visited[curr.flag][nr][nc] = true;
						q.offer(new Point(nr, nc, curr.flag, curr.moveCnt+1));
					} else {
						continue;
					}
				} else if (map[nr][nc] == '1'){ // map[nr][nc] == 1
					visited[curr.flag][nr][nc] = true;
					q.offer(new Point(nr, nc, curr.flag, curr.moveCnt+1));
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int nr, int nc, int N, int M) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	static String str = "7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";
	
}
