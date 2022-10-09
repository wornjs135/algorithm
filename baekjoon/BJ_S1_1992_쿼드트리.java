package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1992_쿼드트리 {
	
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] c = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		if (check(map, 0, 0, N, map[0][0])) {
			sb.append(map[0][0]);
		} else {
			quadtree(map, 0, 0, N/2);
		}
		
		System.out.println(sb);
		in.close();
	}

	private static void quadtree(int[][] map, int start_r, int start_c, int size) {
		sb.append("(");	
		
		// 1사분면
		int first = map[start_r][start_c];
		if(check(map, start_r, start_c, size, first)) {
			sb.append(first);
		} else {
			quadtree(map, start_r, start_c, size/2);
		}
		
		// 2사분면
		first = map[start_r][start_c + size];
		if(check(map, start_r, start_c + size, size, first)) {
			sb.append(first);
		} else {
			quadtree(map, start_r, start_c + size, size/2);
		}
		
		// 3사분면
		first = map[start_r + size][start_c];
		if(check(map, start_r + size, start_c, size, first)) {
			sb.append(first);
		} else {
			quadtree(map, start_r + size, start_c, size/2);
		}
		
		// 4사분면
		first = map[start_r + size][start_c + size];
		if(check(map, start_r + size, start_c + size, size, first)) {
			sb.append(first);
		} else {
			quadtree(map, start_r + size, start_c + size, size/2);
		}
			
		sb.append(")");
	}

	private static boolean check(int[][] map, int start_r, int start_c, int size, int first) {
		for (int i = start_r; i < start_r + size; i++) {
			for (int j = start_c; j < start_c + size; j++) {
				if(map[i][j] != first) return false;
			}
		}
		return true;
	}

//	static String str = "8\r\n" + 
//			"10000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000\r\n" + 
//			"00000000";
}
