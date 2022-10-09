package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7576_토마토 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int M, N;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) queue.offer(new Point(i,j));
				map[i][j] = num;
			}
		}
		
		int day = -1;
		// 토마토 bfs 시작
		while(!queue.isEmpty()) {
			// qSize만큼 반복해서 인접한 토마토 탐색
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				Point temp = queue.poll();
				
				for (int k = 0; k < 4; k++) {
					int nr = temp.r + dr[k];
					int nc = temp.c + dc[k];
					if (isValid(nr, nc) && map[nr][nc] == 0) { // 인접한 안익은 토마토이면 1 넣어주고 큐에 추가
						map[nr][nc] = 1;
						queue.offer(new Point(nr, nc));
					}
				}
			}
			// qSize만큼 돌았으면 하루 증가
			day++;
		}
		
		// 탐색 완료 후 안익은 토마토 남아있으면 day = -1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) day = -1;
			}
		}
		
		sb.append(day);
		System.out.println(sb);
		in.close();
	}

	private static boolean isValid(int nr, int nc) {
		return nr >=0 && nr < N && nc >=0 && nc < M;
	}

//	static String str = "6 4\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 1";
}
