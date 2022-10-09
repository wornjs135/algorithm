package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[] num = new int[N];
			int[] LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			for (int i = 0; i < N; ++i) {
				LIS[i] = 1;
				for (int j = 0; j < i; ++j) {
					if (num[j] < num[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}

				if (max < LIS[i])
					max = LIS[i];
			}
			sb.append(max).append("\n");
		}

		System.out.println(sb);
		in.close();
	}

	static String str = "2\r\n" + "5\r\n" + "1 3 2 5 4\r\n" + "6\r\n" + "4 2 3 1 5 6";

}
