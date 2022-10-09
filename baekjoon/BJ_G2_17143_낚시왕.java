package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G2_17143_낚시왕 {
	
	static int R, C;
	
	static class Shark {
		int s; // 속력
		int d; // 이동 방향 1위 2아래 3오른 4왼
		int z; // 크기
		boolean moved;
		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[][] map = new Shark[R+1][C+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][s] = new Shark(s, d, z);
		}
		
		int result = 0;
		for (int i = 0; i < C; i++) {
			result += fishing(0, i, map);
		}
		
		System.out.println(sb);
		in.close();
	}
	private static int fishing(int startR, int startC, Shark[][] map) {
		int catchShark = 0;
		for (int i = 1; i < R; i++) {
			if(map[i][startC] != null) {
				catchShark = map[i][startC].z;
				map[i][startC] = null;
				break;
			}
		}
		
		moveWhereShark(map);
		
		return catchShark;
	}
	private static void moveWhereShark(Shark[][] map) {	
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == null) continue;
				if(map[i][j].moved) continue;
				if(map[i][j].d == 1 || map[i][j].d == 2) {
					int nextR = (i + map[i][j].s) % (2*(R-1));
					nextR = nextR < (R-1) ? nextR : (2*(R-1)) - nextR;
					
				}
			}
		}
		
	}
	static String str = "4 6 8\r\n" + 
			"4 1 3 3 8\r\n" + 
			"1 3 5 2 9\r\n" + 
			"2 4 8 4 1\r\n" + 
			"4 5 0 1 4\r\n" + 
			"3 3 1 2 7\r\n" + 
			"1 5 8 4 3\r\n" + 
			"3 6 2 1 2\r\n" + 
			"2 2 2 3 5";
}
