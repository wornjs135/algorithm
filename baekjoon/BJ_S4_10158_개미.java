package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(in.readLine());
		
		int x = (p+t) % (2*w);
		int y = (q+t) % (2*h);
			
		if(x < w) {
			sb.append(x).append(" ");
		} else {
			sb.append(2*w - x).append(" ");
		}
		
		if(y < h) {
			sb.append(y).append(" ");
		} else {
			sb.append(2*h - y).append(" ");
		}
		
		System.out.println(sb);
		in.close();
	}

	static String str = "6 4\r\n" + 
			"4 1\r\n" + 
			"8";
	
}
