package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z {
	
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int length = (int) Math.pow(2, N);

		z(length, r, c, 0);

		sb.append(count);
		System.out.println(sb);
		in.close();
	}

	static void z(int length, int r, int c, int cnt) {
		
		if (length == 1) {
			count = cnt;
			return;
		}

		// 1사분면
		if (r < length / 2 && c < length / 2) {
			z(length / 2, r, c, cnt);
		} else if (r < length / 2 && c >= length / 2) { // 2사분면
			z(length / 2, r, c - length / 2, cnt + (length * length / 4));
		} else if (r >= length / 2 && c < length / 2) { // 3사분면
			z(length / 2, r - length / 2, c, cnt + (length * length) / 4 * 2);
		} else { // 4사분면
			z(length / 2, r - length / 2, c - length / 2, cnt + (length * length) / 4 * 3);
		}
	}

//	static String str = "3 7 7";
}
