package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_모의역량테스트_1953_탈주범검거 {
	
	static int N, M;
	static int count;
	static class Point {
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 1;
			bfs(map, R, C, new boolean[N][M], L);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	private static void bfs(int[][] map, int startR, int startC, boolean[][] visited, int lastTime) {
		List<int[]> tunnel = null;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startR, startC, 1));
		visited[startR][startC] = true;
		int time = 1;
		while(time < lastTime) {
			if(q.isEmpty()) {
				time++;
				continue;
			}
			for (int i = 0, size = q.size(); i < size; i++) {
				Point curr = q.poll();
				tunnel = findTunnel(map[curr.r][curr.c]);
				for (int[] near : tunnel) {
					int nr = curr.r + near[0];
					int nc = curr.c + near[1];
					if(isValid(nr, nc) && map[nr][nc] != 0 && !visited[nr][nc] && connectCheck(map, nr, nc, curr.r, curr.c)) {
						q.add(new Point(nr, nc, curr.cnt+1));
						visited[nr][nc] =  true;
						count++;
					}
				}
			}
			time++;
		}
		
	}

	private static boolean connectCheck(int[][] map, int nr, int nc, int currR, int currC) {
		List<int[]> tunnel = findTunnel(map[nr][nc]);
		for (int[] near : tunnel) {
			if(nr + near[0] == currR && nc + near[1] == currC) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >=0 && nc < M;
	}

	static List<int[]> findTunnel(int n) {
		List<int[]> tunnelList = new ArrayList<>();
		if(n == 1) { // 상하좌우
			tunnelList.add(new int[] {0, 1});
			tunnelList.add(new int[] {0, -1});
			tunnelList.add(new int[] {1, 0});
			tunnelList.add(new int[] {-1, 0});
		} else if (n == 2) { // 상하
			tunnelList.add(new int[] {1, 0});
			tunnelList.add(new int[] {-1, 0});
		} else if (n == 3) { // 좌우
			tunnelList.add(new int[] {0, 1});
			tunnelList.add(new int[] {0, -1});
		} else if (n == 4) { // 상우
			tunnelList.add(new int[] {-1, 0});
			tunnelList.add(new int[] {0, 1});
		} else if (n == 5) { // 하우
			tunnelList.add(new int[] {1, 0});
			tunnelList.add(new int[] {0, 1});
		} else if (n == 6) { // 하좌
			tunnelList.add(new int[] {1, 0});
			tunnelList.add(new int[] {0, -1});
		} else if (n == 7){ // 상좌
			tunnelList.add(new int[] {-1, 0});
			tunnelList.add(new int[] {0, -1});
		}
		return tunnelList;
	}
	
	static String str =
			"2\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"5 6 2 2 6\r\n" + 
			"3 0 0 0 0 3\r\n" + 
			"2 0 0 0 0 6\r\n" + 
			"1 3 1 1 3 1\r\n" + 
			"2 0 2 0 0 2\r\n" + 
			"0 0 4 3 1 1";
}
