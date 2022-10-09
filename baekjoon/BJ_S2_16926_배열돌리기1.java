package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_16926_배열돌리기1 {

	static int N;
	static int M;

	private static void spin(int[][] arr, int start) {
		if (start >= Math.min(N, M) / 2) {
			return;
		}

		int temp = arr[start][start];

		for (int i = start; i < M - 1 - start; i++) {
			arr[start][i] = arr[start][i + 1];
		}
		for (int i = start; i < N - 1 - start; i++) {
			arr[i][M - 1 - start] = arr[i + 1][M - 1 - start];
		}
		for (int i = M - 1 - start; i > start; i--) {
			arr[N - 1 - start][i] = arr[N - 1 - start][i - 1];
		}
		for (int i = N - 1 - start; i > start; i--) {
			arr[i][start] = arr[i - 1][start];
		}
		arr[start + 1][start] = temp;

		spin(arr, start + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		int[][] arr = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			spin(arr, 0);
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}

	static String st = "2 2 3\r\n" + "1 1\r\n" + "1 1";
}
