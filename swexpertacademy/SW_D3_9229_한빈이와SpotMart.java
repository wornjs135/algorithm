package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW_D3_9229_한빈이와SpotMart {

	static int max = Integer.MIN_VALUE;
	static int M;

	static void snack(int[] arr, int count, int start, int sum) {
		if (sum > M) {
			return;
		}

		if (count == 2) {
			if (max < sum) {
				max = sum;
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			snack(arr, count + 1, i + 1, sum + arr[i]);
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String[] s = in.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);

			int[] arr = new int[N];
			s = in.readLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}

			snack(arr, 0, 0, 0);
			if (max == Integer.MIN_VALUE) max = -1;
			
			sb.append(max).append("\n");
			max = Integer.MIN_VALUE;
		}

		System.out.println(sb);
		in.close();
	}

//	static String st = "4\r\n" + "3 45\r\n" + "20 20 20\r\n" + "6 10\r\n" + "1 2 5 8 9 11\r\n" + "4 100\r\n"
//			+ "80 80 60 60\r\n" + "4 20\r\n" + "10 5 10 16";
//	
//	static String st = "1\r\n" + 
//			"3 100\r\n" + 
//			"30 20 70";
}
