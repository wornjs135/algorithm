package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1920_수찾기 {

	static int canFind = 0;

	static void findNumber(int[] arr, int find, int start, int end, int mid) {
		if (start > end) {	
			return;
		}

		if (arr[mid] == find) {			
			canFind = 1;
			return;
		} else if (arr[mid] > find) {
			end = mid - 1;
			findNumber(arr, find, start, end, (end + start) / 2);
		} else {
			start = mid + 1;
			findNumber(arr, find, start, end, (end + start) / 2);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(in.readLine());
		int[] confirms = new int[M];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < confirms.length; i++) {
			confirms[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		for (int i = 0; i < confirms.length; i++) {
			findNumber(arr, confirms[i], 0, arr.length - 1, (arr.length - 1) / 2);
			sb.append(canFind).append("\n");
			canFind = 0;
		}

		System.out.println(sb);
		in.close();
	}

//	static String str = "5\r\n" + "4 1 5 2 3\r\n" + "5\r\n" + "1 3 7 9 5";
}
