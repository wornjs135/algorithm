package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] rgbs = new int[N][3];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			rgbs[i][0] = Integer.parseInt(st.nextToken());
			rgbs[i][1] = Integer.parseInt(st.nextToken());
			rgbs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			rgbs[i][0] += Math.min(rgbs[i-1][1], rgbs[i-1][2]);
			rgbs[i][1] += Math.min(rgbs[i-1][0], rgbs[i-1][2]);
			rgbs[i][2] += Math.min(rgbs[i-1][0], rgbs[i-1][1]);
		}
		
		sb.append(Math.min(Math.min(rgbs[N-1][0], rgbs[N-1][1]), rgbs[N-1][2]));
		
		System.out.println(sb);
		in.close();
	}

	static String str = "8\r\n" + 
			"71 39 44\r\n" + 
			"32 83 55\r\n" + 
			"51 37 63\r\n" + 
			"89 29 100\r\n" + 
			"83 58 11\r\n" + 
			"65 13 15\r\n" + 
			"47 25 29\r\n" + 
			"60 66 19";
	
}