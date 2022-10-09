package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {
	
	static class Square {
		int x;
		int y;
		int p;
		int q;
		
		public Square(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = 4;
		Square sq1;
		Square sq2;
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			if(x1 < x2) {
				sq1 = new Square(x1, y1, p1, q1);
				sq2 = new Square(x2, y2, p2, q2);
			} else {
				sq1 = new Square(x2, y2, p2, q2);
				sq2 = new Square(x1, y1, p1, q1);
			}
			
			char result = '0';
			if (sq1.p < sq2.x || sq1.q < sq2.y || sq1.y > sq2.q) {
				result = 'd';
			} else if ((sq1.p == sq2.x && sq1.y == sq2.q) || (sq1.p == sq2.x && sq1.q == sq2.y)) {
				result = 'c';
			} else if (sq1.p == sq2.x || sq1.y == sq2.q || sq1.q == sq2.y) {
				result = 'b';
			}  else {
				result = 'a';
			}
			sb.append(result).append("\n");
		}
		
		
		System.out.println(sb);
		in.close();
	}
	
	static String str = "3 10 50 60 100 100 200 300\r\n" + 
			"45 50 600 600 400 450 500 543\r\n" + 
			"11 120 120 230 50 40 60 440\r\n" + 
			"35 56 67 90 67 80 500 600";
}
