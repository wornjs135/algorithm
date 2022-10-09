package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B2_3040_백설공주와일곱난쟁이 {
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		sb = new StringBuilder();

		int[] dwarf = new int[9];

		for (int i = 0; i < dwarf.length; i++) {
			dwarf[i] = Integer.parseInt(in.readLine());
		}

		findRealDwarf(0, 0, dwarf, new int[7], 0);

		System.out.println(sb);
		in.close();
	}

	private static void findRealDwarf(int cnt, int start, int[] dwarf, int[] realDwarf, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < realDwarf.length; i++) {
					sb.append(realDwarf[i]).append("\n");
				}
			}
			return;
		}

		for (int i = start; i < dwarf.length; i++) {
			realDwarf[cnt] = dwarf[i];
			findRealDwarf(cnt + 1, i + 1, dwarf, realDwarf, sum+dwarf[i]);
		}
	}

//	static String str = "7\r\n" + "8\r\n" + "10\r\n" + "13\r\n" + "15\r\n" + "19\r\n" + "20\r\n" + "23\r\n" + "25";

}
