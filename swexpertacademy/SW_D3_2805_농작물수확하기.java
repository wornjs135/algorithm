package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW_D3_2805_농작물수확하기 {

	static String st = "1\r\n" + "5\r\n" + "14054\r\n" + "44250\r\n" + "02032\r\n" + "51204\r\n" + "52212";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(in.readLine());
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] temp = in.readLine().split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(temp[j]);
				}
			}

			int sum = 0;

			// 농장 위쪽
			for (int i = 0; i <= (N - 1) / 2; i++) {
				for (int j = ((N - 1) / 2) - i; j <= ((N - 1) / 2) + i; j++) {
					sum += farm[i][j];
				}
			}

			int flag = 0;
			// 농장 아래쪽
			for (int i = (N + 1) / 2; i <= N - 1; i++) {
				for (int j = 1 + flag; j <= N - 2 - flag; j++) {
					sum += farm[i][j];
				}
				flag++;
			}

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		in.close();
	}

}
