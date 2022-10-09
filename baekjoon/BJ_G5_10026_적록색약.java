package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_G5_10026_적록색약 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		char[][] map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = in.readLine().toCharArray();
			map[i] = c;
			map2[i] = c.clone();
		}
		
		int normalCnt = 0;
		int patientCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 'X') {
					normal(map, i, j);
					normalCnt++;
				}
				if(map2[i][j] != 'X') {
					patient(map2, i, j);
					patientCnt++;
				}
			}
		}
		sb.append(normalCnt).append(" ").append(patientCnt);
		System.out.println(sb);
		in.close();
	}

	private static void patient(char[][] map, int r, int c) {
		char temp = map[r][c];
		map[r][c] = 'X';
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc)) {
				if (temp == 'B' && map[nr][nc] == 'B') {
					patient(map, nr, nc);
				} else if ((temp == 'R'|| temp == 'G') && (map[nr][nc] == 'R'||map[nr][nc] == 'G')) {
					patient(map, nr, nc);
				}
				
			}
		}
	}

	private static void normal(char[][] map, int r, int c) {
		char temp = map[r][c];
		map[r][c] = 'X';
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc) && temp == map[nr][nc]) {
				map[r][c] = 'X';
				normal(map, nr, nc);
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

//	static String str = "5\r\n" + 
//			"RRRBB\r\n" + 
//			"GGBBB\r\n" + 
//			"BBBRR\r\n" + 
//			"BBRRR\r\n" + 
//			"RRRRR";
	
}
