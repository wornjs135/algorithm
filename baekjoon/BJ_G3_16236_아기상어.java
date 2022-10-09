package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_16236_아기상어 {
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int time = -1;
	static int N;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		
		int curR = 0;
		int curC = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					curR = i;
					curC = j;
				}
			}
		}
		
		bfs(map, curR, curC);
		
		sb.append(time);
		System.out.println(time);
		in.close();
	}

	private static void bfs(int[][] map, int curR, int curC) {
		
		int myPower = 2;
		int countEat = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(curR, curC));
		map[curR][curC] = 0;
		boolean exit = true;
		
		while(!q.isEmpty() && exit) {
			
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				boolean flag = false;
				Point curPoint = q.poll();
				int r = curPoint.r;
				int c = curPoint.c;
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if(isValid(nr, nc) && map[nr][nc] <= myPower) {
						if(map[nr][nc] == myPower || map[nr][nc] == 0) {
							q.offer(new Point(nr, nc));
						} else if (map[nr][nc] < myPower){
							countEat++;
							map[nr][nc] = 0;
							if (countEat == myPower) {
								myPower++;
								countEat = 0;
							}
							q.clear();
							q.offer(new Point(nr, nc));
							flag = true;
							break;
						}
					}
				}
				if(flag) break;
			}
			time++;
			
			exit = false;
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] < myPower) {
						exit = true;
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
		}
	}

	private static boolean isValid(int r, int c) {
		return r >=0 && r < N && c >= 0 && c < N;
	}

	static String str = "3\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0\r\n" + 
			"0 9 0";
	
}
