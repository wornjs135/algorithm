package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G4_14500_테트로미노 {
	
	static int N,M;
	static long max = Integer.MIN_VALUE;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N][M];
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(map, i, j, 1, map[i][j]);
				isVisited[i][j] = false;
				centerCheckt(map, i, j, map[i][j]);
			}
		}
		
		System.out.println(max);
		in.close();
	}
	
	
	private static void dfs(int[][] map, int currR, int currC, int cnt, int sum) {
		
		if(cnt == 4) {
			if(max < sum) {
				max = sum;
			}
				
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = currR + dr[i];
			int nc = currC + dc[i];
			
			if(isValid(nr, nc) && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				dfs(map, nr, nc, cnt+1, sum + map[nr][nc]);
				isVisited[nr][nc] = false;
			}
		}
	}
	
	private static void centerCheckt(int[][] map, int currR, int currC, int sum) {
		
		Integer[] near = new Integer[4];
		int cnt = 0;
		
		if(isValid(currR+1, currC)) {
			near[0] = map[currR+1][currC];
			cnt++;
		} else {
			near[0] = 0;
		}
		
		if(isValid(currR-1, currC)) {
			near[1] = map[currR-1][currC];
			cnt++;
		} else {
			near[1] = 0;
		}
		
		if(isValid(currR, currC+1)) {
			near[2] = map[currR][currC+1];
			cnt++;
		} else {
			near[2] = 0;
		}
		
		if(isValid(currR, currC-1)) {
			near[3] = map[currR][currC-1];
			cnt++;
		} else {
			near[3] = 0;
		}
		
		if(cnt < 3) {
			return;
		}
		
		Arrays.sort(near, Collections.reverseOrder());
		
		for (int i = 0; i < 3; i++) {
			sum += near[i];
		}
		
		if(max < sum) {
			max = sum;
		}
	}
	
	
	
	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}


	static String str = "4 4\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 0 0\r\n" + 
			"0 1 2 3\r\n" + 
			"0 0 4 0";
}
