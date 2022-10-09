package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW_D2_2001_파리퇴치 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			String s = in.readLine();
			int N = Integer.parseInt(s.split(" ")[0]);
			int M = Integer.parseInt(s.split(" ")[1]);
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			for (int l = 0; l < N-M+1; l++) {
				for (int k = 0; k < N-M+1; k++) {
					for (int i = l, count = 1; count <= M; i++, count++) {
						for (int j = k, count2 = 1; count2 <= M; j++, count2++) {
							sum += map[i][j];
						}
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
			}
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}

}
