package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_B2_2309_일곱난쟁이 {

	static StringBuilder sb;
	static boolean flag = false;

	private static void find(int[] people, int[] selected, int cnt, int start, int sum) {
		if (flag) return;
		
		if (cnt == 7) {
			if (sum == 100) {
				flag = true;
				Arrays.sort(selected);
				for (int i = 0; i < selected.length; i++) {
					sb.append(selected[i]).append("\n");
				}
				sb.setLength(sb.length() - 1);
			}
			return;
		}

		for (int i = start; i < people.length; i++) {
			selected[cnt] = people[i];
			find(people, selected, cnt + 1, i + 1, sum + selected[cnt]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(st));
		sb = new StringBuilder();

		int[] people = new int[9];
		int[] selected = new int[7];

		for (int i = 0; i < people.length; i++) {
			people[i] = Integer.parseInt(in.readLine());
		}

		find(people, selected, 0, 0, 0);

		System.out.println(sb);
		in.close();
	}

	static String st = "20\r\n" + 
			"7\r\n" + 
			"23\r\n" + 
			"19\r\n" + 
			"10\r\n" + 
			"15\r\n" + 
			"24\r\n" + 
			"8\r\n" + 
			"13";
}
