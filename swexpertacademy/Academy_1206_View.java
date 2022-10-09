package swexpertacademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Academy_1206_View {

	static boolean isValid(int index, int length) {
		return index - 2 >= 0 && index + 2 < length;

	}

	static int searchView(int[] building, int index) {
		if (building[index] > building[index - 2] && building[index] > building[index - 1]
				&& building[index] > building[index + 1] && building[index] > building[index + 2]) {
			return building[index] - Math.max(Math.max(building[index - 2], building[index - 1]), Math.max(building[index + 1], building[index + 2]));
		}
		return 0;
	}

	public static void main(String[] args) {

		Scanner sc = null;

		int T = 10;

		try {
			System.setIn(new FileInputStream("src/swexpertacademy/input.txt"));
			sc = new Scanner(System.in);

			for (int i = 0; i < T; i++) {
				int view = 0;
				int length = sc.nextInt();
				int[] building = new int[length];

				for (int j = 0; j < building.length; j++) {
					building[j] = sc.nextInt();
				}

				for (int k = 2; k < building.length; k++) {
					if (isValid(k, building.length)) {
						view += searchView(building, k);
					}
				}
				System.out.println("#" + (i+1) + " " + view);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}
