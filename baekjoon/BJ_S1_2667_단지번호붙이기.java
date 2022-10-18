package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_2667_단지번호붙이기 {
	
	static int N;
	static List<Integer> houseCountList;
	static int[][] map;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int houseCount;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		houseCountList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					houseCount = 1;
					dfs(i, j);
					houseCountList.add(houseCount);
				}
			}
		}
		
		Collections.sort(houseCountList);
		
		sb.append(houseCountList.size()).append("\n");
		for (Integer i : houseCountList) {
			sb.append(i).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		in.close();
	}
	
	private static void dfs(int currR, int currC) {
		map[currR][currC] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = currR + dr[i];
			int nc = currC + dc[i];
			if(isValid(nr, nc) && map[nr][nc] == 1) {
				houseCount++;
				dfs(nr, nc);
			}
		}
	}
	
	private static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static String str = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";
}
