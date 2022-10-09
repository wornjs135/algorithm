package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];

		int K = Integer.parseInt(in.readLine());

		int d = R * C;
		int curR = R - 1;
		int curC = 0;
		map[curR][curC] = 1;

		if (K > d) {
			sb.append(0);
		} else if (K == 1) {
			sb.append(1).append(" ").append(1);
		} else {
			for (int i = 2; i <= d; i++) {
				if (curR - 1 >= 0 && map[curR - 1][curC] == 0 && (curC - 1 < 0 || map[curR][curC - 1] != 0)) {
					curR--;
					map[curR][curC] = i;
				} else if (curC + 1 < C && map[curR][curC + 1] == 0) {
					curC++;
					map[curR][curC] = i;
				} else if (curR + 1 < R && map[curR + 1][curC] == 0) {
					curR++;
					map[curR][curC] = i;
				} else if (curC - 1 >= 0 && map[curR][curC - 1] == 0) {
					curC--;
					map[curR][curC] = i;
				}

				if (i == K) {
					break;
				}
			}
			curR = R - curR;
			curC = 1 + curC;

			sb.append(curC).append(" ").append(curR);
		}

		System.out.println(sb);
		in.close();
	}

	static String str = "7 6\r\n" + "87";

}
