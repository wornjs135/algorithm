package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B1_2839_설탕배달 {

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		while (N > 0) {
			if (N % 5 != 0) {
				N -= 3;
				count++;
			} else {
				count += N / 5;
				break;
			}
		}

		if (N < 0) count = -1;

		sb.append(count);

		System.out.println(sb);
		in.close();
	}

//	static String str = "4";
}
