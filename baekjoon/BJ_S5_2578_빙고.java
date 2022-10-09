package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_2578_빙고 {

	static int count = 0;
	static boolean[] bingoCheck = new boolean[12];

	static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void bingo(Integer mc, boolean[][] isChecked, Pair[] pair) {
		isChecked[pair[mc].r][pair[mc].c] = true;

		if (!bingoCheck[0]) {
			if (isChecked[0][0] == true && isChecked[0][1] == true && isChecked[0][2] == true && isChecked[0][3] == true
					&& isChecked[0][4] == true) {
				bingoCheck[0] = true;
				count++;
			}
		}

		if (!bingoCheck[1]) {
			if (isChecked[1][0] == true && isChecked[1][1] == true && isChecked[1][2] == true && isChecked[1][3] == true
					&& isChecked[1][4] == true) {
				bingoCheck[1] = true;
				count++;
			}
		}

		if (!bingoCheck[2]) {
			if (isChecked[2][0] == true && isChecked[2][1] == true && isChecked[2][2] == true && isChecked[2][3] == true
					&& isChecked[2][4] == true) {
				bingoCheck[2] = true;
				count++;
			}
		}

		if (!bingoCheck[3]) {
			if (isChecked[3][0] == true && isChecked[3][1] == true && isChecked[3][2] == true && isChecked[3][3] == true
					&& isChecked[3][4] == true) {
				bingoCheck[3] = true;
				count++;
			}
		}

		if (!bingoCheck[4]) {
			if (isChecked[4][0] == true && isChecked[4][1] == true && isChecked[4][2] == true && isChecked[4][3] == true
					&& isChecked[4][4] == true) {
				bingoCheck[4] = true;
				count++;
			}
		}

		if (!bingoCheck[5]) {
			if (isChecked[0][0] == true && isChecked[1][0] == true && isChecked[2][0] == true && isChecked[3][0] == true
					&& isChecked[4][0] == true) {
				bingoCheck[5] = true;
				count++;
			}
		}

		if (!bingoCheck[6]) {
			if (isChecked[0][1] == true && isChecked[1][1] == true && isChecked[2][1] == true && isChecked[3][1] == true
					&& isChecked[4][1] == true) {
				bingoCheck[6] = true;
				count++;
			}
		}
		
		if (!bingoCheck[7]) {
			if (isChecked[0][2] == true && isChecked[1][2] == true && isChecked[2][2] == true && isChecked[3][2] == true
					&& isChecked[4][2] == true) {
				bingoCheck[7] = true;
				count++;
			}
		}
		
		if (!bingoCheck[8]) {
			if (isChecked[0][3] == true && isChecked[1][3] == true && isChecked[2][3] == true && isChecked[3][3] == true
					&& isChecked[4][3] == true) {
				bingoCheck[8] = true;
				count++;
			}
		}
		
		if (!bingoCheck[9]) {
			if (isChecked[0][4] == true && isChecked[1][4] == true && isChecked[2][4] == true && isChecked[3][4] == true
					&& isChecked[4][4] == true) {
				bingoCheck[9] = true;
				count++;
			}
		}
		
		if (!bingoCheck[10]) {
			if (isChecked[0][0] == true && isChecked[1][1] == true && isChecked[2][2] == true && isChecked[3][3] == true
					&& isChecked[4][4] == true) {
				bingoCheck[10] = true;
				count++;
			}
		}
		
		if (!bingoCheck[11]) {
			if (isChecked[0][4] == true && isChecked[1][3] == true && isChecked[2][2] == true && isChecked[3][1] == true
					&& isChecked[4][0] == true) {
				bingoCheck[11] = true;
				count++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		Pair[] pair = new Pair[26];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				pair[Integer.parseInt(st.nextToken())] = new Pair(i, j);
			}
		}

		boolean[][] isCheked = new boolean[5][5];

		List<Integer> mc = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				mc.add(Integer.parseInt(st.nextToken()));
			}
		}

		int result = 0;
		for (int i = 0; i < mc.size(); i++) {
			bingo(mc.get(i), isCheked, pair);
			if (count >= 3) {
				result = (i + 1);
				break;
			}
		}

		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	static String str = "11 12 2 24 10\r\n" + "16 1 13 3 25\r\n" + "6 20 5 21 17\r\n" + "19 4 8 14 9\r\n"
			+ "22 15 7 23 18\r\n" + "5 10 7 16 2\r\n" + "4 22 8 17 13\r\n" + "3 18 1 6 25\r\n" + "12 19 23 14 21\r\n"
			+ "11 24 9 20 15";
}
