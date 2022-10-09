package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;


// 입출력 연습ver
public class SW_D2_1954_달팽이숫자_교수님ver {

	static String str = "10\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"9\r\n" + 
			"10";
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			
			// 여기부터 로직처리
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		in.close();
	}
}
