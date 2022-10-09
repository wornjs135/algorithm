package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_모의역량테스트_5656_벽돌깨기 {

	static int N;
	static int W;
	static int H;
	static int min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

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
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);

			sb.append(min).append("\n");
		}

		System.out.println(sb);
		in.close();
	}

	static boolean go(int count, int[][] map) { // 중복순열을 이용하여 구슬 던지기, 벽돌이 다 부서졌다면 true, 아니면 false 리턴

		int result = getRemain(map);

		if (result == 0) { // 모든 벽돌이 다 부서졌다면
			min = 0;
			return true;
		}

		if (count == N) { // 모든 구슬 다 던졌다면
			min = Math.min(min, result);
			return false;
		}

		int[][] newMap = new int[H][W];
		// 0열부터 W-1열까지 구슬 던져보기
		for (int c = 0; c < W; c++) {

			// 구슬에 맞는 벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r; // 빈공간이면 계속해서 아래로

			// 해당 열은 벽돌이 없음
			if (r == H)
				continue;

			// 배열의 상태를 백업
			copy(map, newMap);

			boom(newMap, r, c); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리

			down(newMap); // 부서진 벽돌 정리

			if (go(count + 1, newMap))
				return true; // 다음 구슬 던지러 go
		}
		return false;
	}

	static void boom(int[][] map, int r, int c) { // r, c 위치에서 주변의 가능한 모든 벽돌도 함께 부수기
		Queue<Point> queue = new LinkedList<>();
		if (map[r][c] > 1) { // 벽돌크기가 2이면 큐에 담기
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 벽돌크기가 1이면 자신 바로 제거처리

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;

				for (int k = 1; k < p.cnt; k++) { // 벽돌의 크기-1만큼 반복
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W  && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) { // 주변 벽돌에 영향을 주는 벽돌이면
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0; // 빈공간이면 그냥 0, 벽돌이면 제거처리
					}
				}
			}
		}
	}

	static void down(int[][] map) { // 부서진 벽돌 정리, 남은 벽돌 정리(공중에 떠있는 벽돌 내리기)
		for (int c = 0; c < W; c++) {
			int r = H - 1; // 아래행에서 시작
			while (r > 0) {
				if (map[r][c] == 0) { // 빈칸이면 내릴 벽돌 찾기
					int nr = r - 1;
					while (nr > 0 && map[nr][c] == 0)
						nr--;

					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
		}
	}

	static int getRemain(int[][] map) { // 남은 벽돌 수 리턴
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] > 0)
					++count;
			}
		}
		return count;
	}

	static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

	static String str = "2\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
			+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
			+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n"
			+ "1 1 0 1 1 1 0 1 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n"
			+ "1 1 1 1 1 1 1 1 1";

}
