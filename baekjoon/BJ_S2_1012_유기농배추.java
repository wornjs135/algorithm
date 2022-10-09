package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][M];
			
			int K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = true;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]) {
						dfs(map, i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	private static void dfs(boolean[][] map, int i, int j) {
		
		map[i][j] = false;
		
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (isValid(nr, nc) && map[nr][nc]) {
				dfs(map, nr, nc);
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

//	static String str = "2\r\n" + 
//			"10 8 17\r\n" + 
//			"0 0\r\n" + 
//			"1 0\r\n" + 
//			"1 1\r\n" + 
//			"4 2\r\n" + 
//			"4 3\r\n" + 
//			"4 5\r\n" + 
//			"2 4\r\n" + 
//			"3 4\r\n" + 
//			"7 4\r\n" + 
//			"8 4\r\n" + 
//			"9 4\r\n" + 
//			"7 5\r\n" + 
//			"8 5\r\n" + 
//			"9 5\r\n" + 
//			"7 6\r\n" + 
//			"8 6\r\n" + 
//			"9 6\r\n" + 
//			"10 10 1\r\n" + 
//			"5 5";

}
