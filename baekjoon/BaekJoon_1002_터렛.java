package baekjoon;

import java.util.Scanner;

public class BaekJoon_1002_터렛 {

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	private static boolean isEqualPoint(int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2)
			return true;
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int x1, y1, r1, x2, y2, r2 = 0;

			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();

			double distance = getDistance(x1, y1, x2, y2);
			int plusR2 = (r1+r2) * (r1 +r2);
			int absR2 = (r1-r2) * (r1-r2);
			
			if (r1 == r2 && isEqualPoint(x1, y1, x2, y2)) {
				System.out.println(-1);
			} else if (distance > plusR2) {
				System.out.println(0);
			} else if (distance < absR2 || (r1 != r2 && isEqualPoint(x1, y1, x2, y2))) {
				System.out.println(0);
			} else if (distance == plusR2) {
				System.out.println(1);
			} else if (distance == absR2) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
			
		}
		sc.close();
	}

}
