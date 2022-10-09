package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_모의역량테스트_5644_무선충전 {

	static int sum = 0;

	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동시간
			int countBC = Integer.parseInt(st.nextToken()); // BC의 개수

			int[] moveA = new int[M + 1];
			int[] moveB = new int[M + 1];

			// A 움직임
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i < moveA.length; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			// B 움직임
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i < moveB.length; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			BC[] BCList = new BC[countBC];
			for (int i = 0; i < BCList.length; i++) {
				st = new StringTokenizer(in.readLine());
				BCList[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int locAX = 1;
			int locAY = 1;
			int locBX = 10;
			int locBY = 10;
			int cnt = 0;
			while (M >= 0) {
				locAX += dx[moveA[cnt]];
				locAY += dy[moveA[cnt]];
				locBX += dx[moveB[cnt]];
				locBY += dy[moveB[cnt]];

				List<Integer> listA = new ArrayList<>();
				List<Integer> listB = new ArrayList<>();

				for (int i = 0; i < BCList.length; i++) {
					if (BCList[i].canCharge(locAX, locAY)) {
						listA.add(i);
					}
					if (BCList[i].canCharge(locBX, locBY)) {
						listB.add(i);
					}
				}

				if (listA.isEmpty() && !listB.isEmpty()) {
					sum += getMaxP(listB, BCList);
				} else if (listB.isEmpty() && !listA.isEmpty()) {
					sum += getMaxP(listA, BCList);
				} else if (!listA.isEmpty() && !listB.isEmpty()) {
					sum += getMaxP(listA, listB, BCList);
				}

				cnt++;
				M--;
			}

			sb.append(sum).append("\n");
			sum = 0;
		}
		System.out.println(sb);
		in.close();
	}

	private static int getMaxP(List<Integer> listA, List<Integer> listB, BC[] BCList) {
		int max = 0;
		for (int i = 0; i < listA.size(); i++) {
			int a_BC = listA.get(i);
			for (int j = 0; j < listB.size(); j++) {
				int b_BC = listB.get(j);
				int temp = 0;
				if (a_BC == b_BC) {
					temp = BCList[a_BC].P;
				} else {
					temp = BCList[a_BC].P + BCList[b_BC].P;
				}

				if (max < temp) {
					max = temp;
				}
			}
		}
		return max;
	}

	private static int getMaxP(List<Integer> list, BC[] BCList) {
		int max = BCList[list.get(0)].P;
		for (int i = 1; i < list.size(); i++) {
			if (max < BCList[list.get(i)].P) {
				max = BCList[list.get(i)].P;
			}
		}
		return max;
	}

	static class BC {
		int x;
		int y;
		int C;
		int P;

		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}

		boolean canCharge(int locX, int locY) {
			int d = Math.abs(locX - this.x) + Math.abs(locY - this.y);
			if (this.C >= d) {
				return true;
			}
			return false;
		}
	}

//	static String str = "5\r\n" + "20 3\r\n" + "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n"
//			+ "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" + "4 4 1 100\r\n" + "7 10 3 40\r\n" + "6 3 2 70\r\n"
//			+ "40 2\r\n" + "0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \r\n"
//			+ "0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \r\n" + "5 2 4 140\r\n"
//			+ "8 3 3 490\r\n" + "60 4\r\n"
//			+ "0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \r\n"
//			+ "1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \r\n"
//			+ "6 9 1 180\r\n" + "9 3 4 260\r\n" + "1 4 1 500\r\n" + "1 3 1 230\r\n" + "80 7\r\n"
//			+ "2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \r\n"
//			+ "4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \r\n"
//			+ "4 3 1 170\r\n" + "10 1 3 240\r\n" + "10 5 3 360\r\n" + "10 9 3 350\r\n" + "9 6 2 10\r\n"
//			+ "5 1 4 350\r\n" + "1 8 2 450\r\n" + "100 8\r\n"
//			+ "2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \r\n"
//			+ "4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \r\n"
//			+ "3 4 2 340\r\n" + "10 1 1 430\r\n" + "3 10 4 10\r\n" + "6 3 4 400\r\n" + "7 4 1 80\r\n" + "4 5 1 420\r\n"
//			+ "4 1 2 350\r\n" + "8 4 4 300\r\n";
}
