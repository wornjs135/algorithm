package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_D2_1954_달팽이숫자 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
//			sb.append("#").append(test_case).append("\n");
			int N = Integer.parseInt(in.readLine());

			int[][] arr = new int[N][N];
			arr[0][0] = 1;

			int start_r = 0;
			int start_c = 0;

			for (int i = 2; i <= N * N; i++) {
				if (start_c + 1 < N && arr[start_r][start_c + 1] == 0
						&& (start_r - 1 < 0 || arr[start_r - 1][start_c] != 0)) {
					start_c++;
					arr[start_r][start_c] = i;
				} else if (start_r + 1 < N && arr[start_r + 1][start_c] == 0) {
					start_r++;
					arr[start_r][start_c] = i;
				} else if (start_c - 1 >= 0 && arr[start_r][start_c - 1] == 0) {
					start_c--;
					arr[start_r][start_c] = i;
				} else if (start_r - 1 >= 0 && arr[start_r - 1][start_c] == 0) {
					start_r--;
					arr[start_r][start_c] = i;
				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

		in.close();
	}

}
