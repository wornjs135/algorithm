package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_G4_2239_스도쿠 {

	static StringBuilder sb = new StringBuilder();
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));

		int[][] map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String[] s = in.readLine().split("");
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		dfs(map, 0, 0);

		in.close();
	}

	private static void dfs(int[][] map, int currR, int currC) {
		if (currR == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		if (map[currR][currC] == 0) {
			for (int n = 1; n <= 9; n++) {
				if (checkSudoku(n, map, currR, currC)) {
					map[currR][currC] = n;
					if (currC + 1 < 9) {
						dfs(map, currR, currC + 1);
					} else if (currC + 1 >= 9) {
						dfs(map, currR + 1, 0);
					}
					map[currR][currC] = 0;
				}
			}
		} else {
			if (currC + 1 < 9) {
				dfs(map, currR, currC + 1);
			} else if (currC + 1 >= 9) {
					dfs(map, currR + 1, 0);
			}
		}
	}

	private static boolean checkSudoku(int n, int[][] map, int currR, int currC) {
		// 가로, 세로
		for (int i = 0; i < 9; i++) {
			if (n == map[currR][i])
				return false;
			
			if (n == map[i][currC])
				return false;
		}

		// 3x3
		for (int i = (currR / 3) * 3; i < (currR / 3) * 3 + 3; i++) {
			for (int j = (currC / 3) * 3; j < (currC / 3) * 3 + 3; j++) {
				if (n == map[i][j])
					return false;
			}
		}

		return true;
	}

	static String str = "103000509\r\n" + "002109400\r\n" + "000704000\r\n" + "300502006\r\n" + "060000050\r\n"
			+ "700803004\r\n" + "000401000\r\n" + "009205800\r\n" + "804000107";
}
