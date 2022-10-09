package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_16935_배열돌리기3 {

	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);

		arr = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		while (st.hasMoreTokens()) {
			switch (st.nextToken()) {
			case "1":
				calc1();
				break;
			case "2":
				calc2();
				break;
			case "3":
				calc3();
				break;
			case "4":
				calc4();
				break;
			case "5":
				calc5();
				break;
			case "6":
				calc6();
				break;
			}
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

	private static void calc6() {
		int[][] temp = new int[N / 2][M / 2];
		// part2를 temp에 저장
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = arr[i][M / 2 + j];
			}
		}

		// 3 -> 2
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[i][M / 2 + j] = arr[N / 2 + i][M / 2 + j];
			}
		}

		// 4 -> 3
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[N / 2 + i][M / 2 + j] = arr[N / 2 + i][j];
			}
		}

		// 1 -> 4
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[N / 2 + i][j] = arr[i][j];
			}
		}

		// temp -> 1
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	private static void calc5() {
		int[][] temp = new int[N / 2][M / 2];
		// part2를 temp에 저장
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = arr[i][M / 2 + j];
			}
		}

		// 1 -> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[i][M / 2 + j] = arr[i][j];
			}
		}

		// 4 -> 1
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[i][j] = arr[N / 2 + i][j];
			}
		}

		// 3 -> 4
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[N / 2 + i][j] = arr[N / 2 + i][M / 2 + j];
			}
		}

		// temp -> 3
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				arr[N / 2 + i][M / 2 + j] = temp[i][j];
			}
		}
	}

	private static void calc4() {
		int[][] arr2 = new int[M][N];
		int r = -1;
		int c = 0;
		for (int j = M - 1; j >= 0; j--) {
			r++;
			c = 0;
			for (int i = 0; i < N; i++) {
				arr2[r][c] = arr[i][j];
				c++;
			}
		}
		arr = arr2;
		int temp = M;
		M = N;
		N = temp;
	}

	private static void calc3() {
		int[][] arr2 = new int[M][N];
		int r = -1;
		int c = 0;
		for (int j = 0; j < M; j++) {
			r++;
			c = 0;
			for (int i = N - 1; i >= 0; i--) {
				arr2[r][c] = arr[i][j];
				c++;
			}
		}
		arr = arr2;
		int temp = M;
		M = N;
		N = temp;
	}

	private static void calc2() {
		int[] temp = new int[N];
		for (int j = 0; j < M / 2; j++) {
			for (int i = 0; i < N; i++) {
				temp[i] = arr[i][j];
				arr[i][j] = arr[i][M - 1 - j];
				arr[i][M - 1 - j] = temp[i];
			}
		}
	}

	private static void calc1() {
		for (int i = 0; i < N / 2; i++) {
			int[] temp = arr[i].clone();
			arr[i] = arr[N - 1 - i];
			arr[N - 1 - i] = temp;
		}
	}

	static String str = "6 8 6\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
			+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "1 2 3 4 5 6";
}
