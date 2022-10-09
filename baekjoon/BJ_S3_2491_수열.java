package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_2491_수열 {

	static int N;
	static int ascMax = 1;
	static int descMax = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		int[] number = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		int ascCnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (number[i] <= number[i + 1]) {
				ascCnt++;
			} else {
				ascCnt = 1;
			}
			if (ascMax < ascCnt) {
				ascMax = ascCnt;
			}
		}

		int descCnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (number[i] >= number[i + 1]) {
				descCnt++;
			} else {
				descCnt = 1;
			}
			if (descMax < descCnt) {
				descMax = descCnt;
			}
		}

		int result = Math.max(ascMax, descMax);
		sb.append(result);
		System.out.println(sb);
		in.close();
	}

//	static String str = "11\r\n" + 
//			"1 5 3 6 4 7 1 3 2 9 5";

}
