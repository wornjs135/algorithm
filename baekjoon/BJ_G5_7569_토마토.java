package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7569_토마토 {

	static int N, M, H, totalTomato;
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int isGrownCount = 0;

	static class Point {
		int r;
		int c;
		int h;

		public Point(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken()); // C
		N = Integer.parseInt(st.nextToken()); // R
		H = Integer.parseInt(st.nextToken());

		int[][][] map = new int[N][M][H];
		totalTomato = N*M*H;
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if (map[j][k][i] == -1) {
						totalTomato--;
					} else if (map[j][k][i] == 1) {
						q.add(new Point(j, k, i));
						isGrownCount++;
					}
				}
			}
		}

		bfs(map, q);

		in.close();
	}

	/*
	 * 보통 isVisited 배열을 선언해서 방문체크를 하는데 여기서는 이걸 사용하면 시간초과남.
	 * 방문을 하고 해당 칸의 값을 1로 바꿔주면 방문한 장소라고 치기때문에 굳이 안해줘도 됨.
	 * 방문 조건 탐색할때 0인지 아닌지만 판별해주면 됨.
	 * */
	private static void bfs(int[][][] map, Queue<Point> q) {
		int result = 0;
				
		// 하루 지나서 토마토 익기
		while(!q.isEmpty()) {
			// 다 익었으면 끝
			if (isGrownCount == totalTomato) {
				System.out.println(result);
				System.exit(0);
			}
			
			for (int i = 0, size = q.size(); i < size; i++) {
				Point temp = q.poll();
				for (int k = 0; k < 6; k++) {
					int nr = temp.r + dr[k];
					int nc = temp.c + dc[k];
					int nh = temp.h + dh[k];
					
					if (isValid(nr, nc, nh) &&  map[nr][nc][nh] == 0) {
						q.add(new Point(nr, nc, nh));
						map[nr][nc][nh] = 1;
						isGrownCount++;
					}
				}
			}
			
			result++;
		}
		
		System.out.println(-1);
		System.exit(0);
	}

	private static boolean isValid(int nr, int nc, int nh) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H;
	}

}