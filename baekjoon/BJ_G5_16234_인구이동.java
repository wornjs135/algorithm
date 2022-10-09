package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_16234_인구이동 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] isOpened = new boolean[N][N];
		
		int cnt = 0;
		while (true) {
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isOpened[i][j])
						continue;
					isOpened[i][j] = true;
					boolean result = bfs(map, N, L, R, i, j, isOpened);
					
					if(!flag)
						flag = result;


					System.out.println(result);
//					if(!result) {
//						System.out.println(cnt);
//						System.exit(0);
//					}
					for (int k = 0; k < isOpened.length; k++) {
						for (int l = 0; l < isOpened.length; l++) {
							System.out.print(map[k][l] + " ");
						}
						System.out.println();
					}
					isOpened = new boolean[N][N];
					
				}
				
			}
			if(!flag) {
				System.out.println(cnt);
				System.exit(0);
			} else {
				cnt++;
			}
		}

		

//		for (int i = 0; i < isOpened.length; i++) {
//			for (int j = 0; j < isOpened.length; j++) {
//				System.out.print(isOpened[i][j] ? "O" : "X");
//			}
//			System.out.println();
//		}

		

	}

	private static boolean bfs(int[][] map, int N, int L, int R, int currR, int currC, boolean[][] isOpened) {
		System.out.println("현재 좌표 : " + currR + " " + currC);
		int sum = 0;
		sum += map[currR][currC];
		boolean flag = false;
		Stack<Point> stack = new Stack<>();
		stack.add(new Point(currR, currC));

		Queue<Point> pq = new LinkedList<>();
		pq.add(new Point(currR, currC));
		while (!pq.isEmpty()) {
			System.out.println("q사이즈:" + pq.size());
			Point temp = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if (isValid(N, nr, nc) && (!isOpened[nr][nc]) && Math.abs(map[temp.r][temp.c] - map[nr][nc]) >= L
						&& Math.abs(map[temp.r][temp.c] - map[nr][nc]) <= R) {
					System.out.println("여기");
					isOpened[nr][nc] = true;
					pq.offer(new Point(nr, nc));
					stack.add(new Point(nr, nc));
					sum += map[nr][nc];
				}
			}
		}

		int size = stack.size();
		if (size > 1) {
			flag = true;
			System.out.println("스택 사이즈: " +  stack.size());
			int e = sum / size;
			while (!stack.isEmpty()) {
				Point temp = stack.pop();
				map[temp.r][temp.c] = e;
			}
		}

		return flag;
	}

	private static boolean isValid(int N, int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static String str = "4 10 50\r\n" + 
			"10 100 20 90\r\n" + 
			"80 100 60 70\r\n" + 
			"70 20 30 40\r\n" + 
			"50 20 100 10";
}
