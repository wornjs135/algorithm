package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_21610_마법사상어와비바라기 {

	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {1, -1, 1, -1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int M = Integer.parseInt(st.nextToken());
		int[][] move = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visited = new boolean[N][N];
		visited[N - 1][0] = true;
		visited[N - 1][1] = true;
		visited[N - 2][0] = true;
		visited[N - 2][1] = true;

		for (int i = 0; i < M; i++) {
			boolean[][] nextVisited = new boolean[N][N];
			moveCloud(map, move[i], visited, nextVisited);

		}
		
		int result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				result += map[r][c];
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	private static void moveCloud(int[][] map, int[] moveInfo, boolean[][] visited, boolean[][] nextVisited) {
		int[] d = whatDirection(moveInfo);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					int r = i;
					int c = j;
					for (int k = 0; k < moveInfo[1]; k++) {
						r+= d[0];
						c+= d[1];
						if (r == N) {
							r = 0;
						} else if (r == -1) {
							r = N - 1;
						}
						if (c == N) {
							c = 0;
						} else if (c == -1) {
							c = N - 1;
						}
					}
					nextVisited[r][c] = true;
					map[r][c] += 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(nextVisited[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(isValid(nr, nc) && map[nr][nc] != 0) {
							map[i][j] += 1;
						}
					}
				} 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!nextVisited[i][j] && map[i][j] >= 2) {
					visited[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}
		
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	private static int[] whatDirection(int[] moveInfo) {
		int[] dArr = new int[2];
		int moveNum = moveInfo[0];
		if (moveNum == 1) {
			dArr[0] = 0;
			dArr[1] = -1;
			return dArr;
		} else if (moveNum == 2) {
			dArr[0] = -1;
			dArr[1] = -1;
			return dArr;
		} else if (moveNum == 3) {
			dArr[0] = -1;
			dArr[1] = 0;
			return dArr;
		} else if (moveNum == 4) {
			dArr[0] = -1;
			dArr[1] = 1;
			return dArr;
		} else if (moveNum == 5) {
			dArr[0] = 0;
			dArr[1] = 1;
			return dArr;
		} else if (moveNum == 6) {
			dArr[0] = 1;
			dArr[1] = 1;
			return dArr;
		} else if (moveNum == 7) {
			dArr[0] = 1;
			dArr[1] = 0;
			return dArr;
		} else if (moveNum == 8) {
			dArr[0] = 1;
			dArr[1] = -1;
			return dArr;
		}

		return null;
	}

	static String str = "5 4\r\n" + "0 0 1 0 2\r\n" + "2 3 2 1 0\r\n" + "4 3 2 9 0\r\n" + "1 0 2 9 0\r\n"
			+ "8 8 2 1 0\r\n" + "1 3\r\n" + "3 4\r\n" + "8 1\r\n" + "4 8";
}
