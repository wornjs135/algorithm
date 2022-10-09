package swexpertacademy;

import java.io.*;
import java.util.Scanner;


public class Academy_1204_최빈수구하기 {

	public static void main(String[] args) {

		Scanner sc = null;
		try {
			System.setIn(new FileInputStream("src/swexpertacademy/input.txt"));
			sc = new Scanner(System.in);

			int T = sc.nextInt();
			int[][] score = new int[T][101];

			for (int i = 0; i < T; i++) {
				int test_case = sc.nextInt();

				for (int j = 0; j < 1000; j++) {
					int temp = sc.nextInt();
					score[i][temp]++;
				}

				int max = Integer.MIN_VALUE;
				int max_value = 0;
				for (int j = 0; j < score[i].length; j++) {

					if (max <= score[i][j]) {
						max = score[i][j];
						max_value = j;
					}
				}

				System.out.println("#" + test_case + " " + (max_value));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}
