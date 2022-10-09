package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_SWTestSample_1767_프로세서연결하기 {
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int maxCore = Integer.MIN_VALUE;
	static int minWireLen = Integer.MAX_VALUE;
	static int N;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			List<Point> corePoints = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(map[i][j] == 1) corePoints.add(new Point(i, j));
				}
			}
			
			dfs(map, corePoints, 0, 0, 0);
			
			sb.append(minWireLen).append("\n");
			minWireLen = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
		}
		
		System.out.println(sb);
		in.close();
	}

	private static void dfs(int[][] map, List<Point> corePoints, int index, int coreCnt, int wireLen) {
		if(index == corePoints.size()) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minWireLen = wireLen;
			} else if (maxCore == coreCnt) {
				minWireLen = Math.min(wireLen, minWireLen);
			}
			return;
		}
		
		int currR = corePoints.get(index).r;
		int currC = corePoints.get(index).c;
		for (int i = 0; i < 4; i++) {
			int nr = currR;
			int nc = currC;
			int cnt = 0;
			while(true) {
				nr += dr[i];
				nc += dc[i];
				if(nr < 0 || nr>=N || nc<0 || nc>=N) break;
                
				if(map[nr][nc] == 1) {
					cnt = 0;
					break;
				} 
				
				cnt++;
			}
			
			int tempR = currR;
			int tempC = currC;
			for (int j = 0; j < cnt; j++) {
				tempR += dr[i];
				tempC += dc[i];
				map[tempR][tempC] = 1;
			}
			
			if(cnt != 0) {
				dfs(map, corePoints, index+1, coreCnt+1, wireLen + cnt);
				tempR = currR;
				tempC = currC;
				for (int j = 0; j < cnt; j++) {
					tempR += dr[i];
					tempC += dc[i];
					map[tempR][tempC] = 0;
				}
			} else {
				dfs(map, corePoints, index+1, coreCnt, wireLen);
			}
		}
		
	}

	static String str = "3\r\n" + 
			"7\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"1 1 0 1 0 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 1\r\n" + 
			"11\r\n" + 
			"0 0 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 1 0 1 1 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0";

}
