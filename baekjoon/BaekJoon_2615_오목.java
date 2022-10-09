package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon_2615_오목 {

	public static boolean isValid(int nr, int nc) {
		if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(
//				new InputStreamReader(new FileInputStream("src/baekjoon/2615_input.txt")));
		Scanner sc = new Scanner(System.in);

		int[][] omok = new int[19][19];
		int[] dr = { -1, 0, 1, 1 };
		int[] dc = { 1, 1, 1, 0 };
		int winner = 0;
		int win_x = 0;
		int win_y = 0;
		boolean isEnd = false;
		boolean isEnd2 = false;

		for (int i = 0; i < omok.length; i++) {
//			String str = in.readLine();
//			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < omok.length; j++) {
				omok[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < omok.length; i++) {
			for (int j = 0; j < omok.length; j++) {
				if (omok[i][j] != 0) {
					for (int j2 = 0; j2 < dc.length; j2++) {
						int count = 1;
						boolean sixmok = false;
						int nr = i + dr[j2];
						int nc = j + dc[j2];

						if (isValid(i - dr[j2], j - dc[j2]) && omok[i][j] == omok[i - dr[j2]][j - dc[j2]]) {
							sixmok = true;
						}

						while (isValid(nr, nc) && omok[i][j] == omok[nr][nc]) {
							count++;
							nr = nr + dr[j2];
							nc = nc + dc[j2];
						}

						if (count == 5 && !sixmok) {
							isEnd = true;
							break;
						}
					}
				}
				if (isEnd) {
					winner = omok[i][j];
					win_x = i + 1;
					win_y = j + 1;
					isEnd2 = true;
					break;
				}
			}
			if (isEnd2)
				break;
		}
		System.out.println(winner);
		if (winner != 0) {
			System.out.println(win_x + " " + win_y);
		}

	}
}
