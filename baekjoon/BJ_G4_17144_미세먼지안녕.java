package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_17144_미세먼지안녕 {
	static int R, C;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		int minusOneCount = 1;
		int[][] air  = new int[2][2];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (minusOneCount == 1) {
						air[0][0] = i;
						air[0][1] = j;
						minusOneCount++;
					} else {
						air[1][0] = i;
						air[1][1] = j;
					}
				}
				
			}
		}
		
		
		int startR = air[0][0];
		int startC = air[0][1];
		int d = C * (startR+1);
		for (int i = 0; i < T; i++) {
			// 확산
			int[][] temp = new int[R][C];
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = j + dr[k];
						int nc = j2 + dc[k];
						if (isValid(nr, nc) && map[nr][nc] != -1) {
							temp[nr][nc] += map[j][j2]/5;
							cnt++;
						}
					}
					map[j][j2] = map[j][j2] - (map[j][j2]/5 * cnt);
				}
			}
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					if (temp[j][j2] != 0) {
						map[j][j2] += temp[j][j2];
					}
				}
			}
			
			// 위쪽 공기 돌기
			int tempN = map[0][0];
			for (int j = 0; j < C-1; j++) {
				map[0][j] = map[0][j+1];
			}
			for (int j = 0; j < startR; j++) {
				map[j][C-1] = map[j+1][C-1];
			}
			for (int j = C-1; j > 0; j--) {
				map[startR][j] = map[startR][j-1];
			}
			for (int j = startR; j > 0; j--) {
				map[j][0] = map[j-1][0];
			}
			map[startR][startC] = -1;
			map[startR][1] = 0;
			map[1][0] = tempN;
			
			// 아래쪽 공기 돌기
			int tempN2 = map[air[1][0]][0];
			for (int j = air[1][0]; j < R-1; j++) {
				map[j][0] = map[j+1][0];
			}
			for (int j = 0; j < C-1; j++) {
				map[R-1][j] = map[R-1][j+1];
			}
			for (int j = R-1; j > air[1][0]; j--) {
				map[j][C-1] = map[j-1][C-1];
			}
			for (int j = C-1; j > 0; j--) {
				map[air[1][0]][j] = map[air[1][0]][j-1];
			}
			map[air[1][0]][1] = tempN2;
			map[air[1][0]][air[1][1]] = -1;
			map[air[1][0]][1] = 0;
		}
		
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
//				System.out.print(map[i][j]+" ");
			}
//			System.out.println();
		}
		sb.append(result+2);
		
		System.out.println(sb);
		in.close();
	}
	
	private static boolean isValid(int nr, int nc) {
		return nr >=0 && nr < R && nc >=0 && nc < C;
	}

	static String str = "7 8 3\r\n" + 
			"0 0 0 0 0 0 0 9\r\n" + 
			"0 0 0 0 3 0 0 8\r\n" + 
			"-1 0 5 0 0 0 22 0\r\n" + 
			"-1 8 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 10 43 0\r\n" + 
			"0 0 5 0 15 0 0 0\r\n" + 
			"0 0 40 0 0 0 20 0";
	
}
