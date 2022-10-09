package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(in.readLine());
			String[] s = in.readLine().split(" ");
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			// N이 홀수
			if (N % 2 != 0) {
				for (int i = 0; i <= N/2; i++) {
					q1.add(s[i]);
				}
				for (int i = N/2+1; i < s.length; i++) {
					q2.add(s[i]);
				}
			} else { // N이 짝수
				for (int i = 0; i < N/2; i++) {
					q1.add(s[i]);
				}
				for (int i = N/2; i < s.length; i++) {
					q2.add(s[i]);
				}
			}
			
			while(!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty()) {
					sb.append(q1.poll()).append(" ");
				}
				if (!q2.isEmpty()) {
					sb.append(q2.poll()).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}

	
	static String str=
			"3\r\n" + 
			"6\r\n" + 
			"A B C D E F\r\n" + 
			"4\r\n" + 
			"JACK QUEEN KING ACE\r\n" + 
			"5\r\n" + 
			"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
}
