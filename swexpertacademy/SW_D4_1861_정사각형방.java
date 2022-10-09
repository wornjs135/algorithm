package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW_D4_1861_정사각형방 {

	static int N;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int max_count = Integer.MIN_VALUE;
	static int max_room_number = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					nextRoom(map, i, j, i, j, 1);
				}
			}

			sb.append(max_room_number).append(" ").append(max_count).append("\n");
			
			max_count = Integer.MIN_VALUE;
			max_room_number = Integer.MAX_VALUE;
		}

		System.out.println(sb);
		in.close();
	}

	static void nextRoom(int[][] map, int start_i, int start_j, int curr_i, int curr_j, int count) {
		if(max_count == count && max_room_number > map[start_i][start_j]) {
			max_room_number = map[start_i][start_j];
		}
		
		if (max_count < count) {
			max_count = count;
			max_room_number = map[start_i][start_j];
		}

		for (int k = 0; k < 4; k++) {
			int nr = curr_i + dr[k];
			int nc = curr_j + dc[k];
			if (isValid(nr, nc) && map[curr_i][curr_j] + 1 == map[nr][nc]) {
				nextRoom(map, start_i, start_j, nr, nc, count + 1);
				break;
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

//	static String str = "2\r\n" + "2\r\n" + "1 2\r\n" + "3 4\r\n" + "3\r\n" + "9 3 4\r\n" + "6 1 5\r\n" + "7 8 2";
}
