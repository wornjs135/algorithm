package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BJ_S1_9465_스티커 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] sticker = new int[2][N];
			
			StringTokenizer st = null;
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int j = 1; j < N; j++) {
				for (int i = 0; i < 2; i++) {
					if(i == 0) {
						int left = sticker[i][j-1];
						int leftdown = sticker[i+1][j-1] + sticker[i][j];
						sticker[i][j] = Math.max(left, leftdown);
					} else {
						int left = sticker[i][j-1];
						int leftup = sticker[i-1][j-1] + sticker[i][j];
						sticker[i][j] = Math.max(left, leftup);
					}
				}
			}
			
			sb.append(Math.max(sticker[0][N-1], sticker[1][N-1])).append("\n");			
		}
		System.out.println(sb);
		in.close();
	}
	
	static String str = "2\r\n" + 
			"5\r\n" + 
			"50 10 100 20 40\r\n" + 
			"30 50 70 10 60\r\n" + 
			"7\r\n" + 
			"10 30 10 50 100 20 40\r\n" + 
			"20 40 30 50 60 20 80";
}
