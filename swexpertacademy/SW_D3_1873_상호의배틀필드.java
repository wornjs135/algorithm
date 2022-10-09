package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW_D3_1873_상호의배틀필드 {

	static String str = "1\r\n" + 
			"3 7\r\n" + 
			"***....\r\n" + 
			"*-..#**\r\n" + 
			"#<.****\r\n" + 
			"23\r\n" + 
			"SURSSSSUSLSRSSSURRDSRDS";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/swexpertacademy/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dr = {-1, 1, 0, 0};       // 상-0, 하-1, 좌-2, 우-3
		int[] dc = {0, 0, -1, 1};
		
		for (int tc = 1; tc <= T; tc++) {
			char tankDir = '0';
			int tank_r = 0;
			int tank_c = 0;
			
			sb.append("#").append(tc).append(" ");
			String s = in.readLine(); // 3 7
			
			int H = Integer.parseInt(s.split(" ")[0]); // 3
			int W = Integer.parseInt(s.split(" ")[1]); // 7
			
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			int N = Integer.parseInt(in.readLine());
			char[] action = in.readLine().toCharArray();
			
			// 탱크 찾기.
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tank_r = i;
						tank_c = j;
						tankDir = map[i][j];
					}
				}
			}
			
			for (int a = 0; a < action.length; a++) {
				if (action[a] == 'S') {
					int direction = directionIndex(tankDir);
					int nr = tank_r + dr[direction];
					int nc = tank_c + dc[direction];
					
					while(true) {
						if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
						
						if (map[nr][nc] == '#') {
							break;
						} else if (map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						} else {
							nr = nr + dr[direction];
							nc = nc + dc[direction];
							continue;
						}
					}
				} else {
					if (action[a] == 'U') {
						tankDir = '^';
						map[tank_r][tank_c] = '^';
						int direction = directionIndex(tankDir);
						int nr = tank_r + dr[direction];
						int nc = tank_c + dc[direction];
						if (isValid(nr, nc, H, W) && map[nr][nc] == '.') {
							map[tank_r][tank_c] = '.';
							tank_r = nr;
							tank_c = nc;
							map[tank_r][tank_c] = '^';
						}
					} else if (action[a] == 'D') {
						tankDir = 'v';
						map[tank_r][tank_c] = 'v';
						int direction = directionIndex(tankDir);
						int nr = tank_r + dr[direction];
						int nc = tank_c + dc[direction];
						if (isValid(nr, nc, H, W) && map[nr][nc] == '.') {
							map[tank_r][tank_c] = '.';
							tank_r = nr;
							tank_c = nc;
							map[tank_r][tank_c] = 'v';
						}
					} else if (action[a] == 'L') {
						tankDir = '<';
						map[tank_r][tank_c] = '<';
						int direction = directionIndex(tankDir);
						int nr = tank_r + dr[direction];
						int nc = tank_c + dc[direction];
						if (isValid(nr, nc, H, W) && map[nr][nc] == '.') {
							map[tank_r][tank_c] = '.';
							tank_r = nr;
							tank_c = nc;
							map[tank_r][tank_c] = '<';
						}
					} else if (action[a] == 'R') {
						tankDir = '>';
						map[tank_r][tank_c] = '>';
						int direction = directionIndex(tankDir);
						int nr = tank_r + dr[direction];
						int nc = tank_c + dc[direction];
						if (isValid(nr, nc, H, W) && map[nr][nc] == '.') {
							map[tank_r][tank_c] = '.';
							tank_r = nr;
							tank_c = nc;
							map[tank_r][tank_c] = '>';
						}
					}
					
				}	
			}
			
			// 결과 출력
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
		in.close();
	}

	private static int directionIndex(char tankDir) {
		if (tankDir == '^') {
			return 0;
		} else if (tankDir == 'v') {
			return 1;
		} else if (tankDir == '<') {
			return 2;
		} else if (tankDir == '>') {
			return 3;
		}
		return -1;
	}
	
	private static boolean isValid(int nr, int nc, int H, int W) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}

}
