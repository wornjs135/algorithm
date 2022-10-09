package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int[] map = new int[100];

			int dump = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine());

			for (int i = 0; i < 100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			int result = 0;
			for (int i = 0; i < dump; i++) {
				map[99] -= 1;
				map[0] += 1;
				Arrays.sort(map);

				result = map[99] - map[0];
				if (result == 0 || result == 1) {
					sb.append(result + "\n");
					break;
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
		in.close();
	}
}
