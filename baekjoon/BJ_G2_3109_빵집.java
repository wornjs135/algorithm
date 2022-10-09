package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G2_3109_빵집 {

	static int R, C;
	static int count = 0;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static boolean finish;

	public static void findPipeLine(int start_r, int start_c) {

		if (start_c == C-1) {
			count++;
			finish = true;
			return;
		} 
			
		map[start_r][start_c] = 'x';
		for (int i = 0; i < 3; i++) {
			int nr = start_r + dr[i];
			int nc = start_c + dc[i];
			
			if (nr >= 0  && nr < R && nc < C && map[nr][nc] == '.') {
				findPipeLine(nr, nc);
			}
			if(finish) return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			finish = false;
			findPipeLine(i, 0);
		}

		sb.append(count);
		System.out.println(sb);
		in.close();
	}

//	static String str = "5 9\r\n" + 
//			".x.....x.\r\n" + 
//			".x..x..x.\r\n" + 
//			".x..x..x.\r\n" + 
//			"....x....\r\n" + 
//			".x..x..x.";
}
