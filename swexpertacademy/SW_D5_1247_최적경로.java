package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D5_1247_최적경로 {

	static int N, distance;
	static Location[] loc;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			loc = new Location[N];
			StringTokenizer st = new StringTokenizer(in.readLine());

			Location company = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Location home = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < loc.length; i++) {
				loc[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(loc);

			do {
				for (int i = 0, size = loc.length - 1; i < size; i++) {
					distance += Math.abs(loc[i].r - loc[i + 1].r) + Math.abs(loc[i].c - loc[i + 1].c);
				}
				distance += Math.abs(company.r - loc[0].r) + Math.abs(company.c - loc[0].c)
						+ Math.abs(home.r - loc[N - 1].r) + Math.abs(home.c - loc[N - 1].c);
				if (min > distance)
					min = distance;
				distance = 0;
			} while (np());

			sb.append(min).append("\n");
			min = Integer.MAX_VALUE;
		}

		System.out.println(sb);
		in.close();
	}

	private static boolean np() {

		// 바꿀 위치 찾기
		int i = N - 1;
		while (i > 0 && loc[i - 1].r >= loc[i].r)
			i--;

		if (i == 0)
			return false;

		// 교환 위치에 교환할 값 찾기
		int j = N - 1;
		while (loc[i - 1].r >= loc[j].r)
			j--;

		// 교환하기
		swap(i - 1, j);

		// 뒤에꺼 정렬하기
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		Location temp = loc[i];
		loc[i] = loc[j];
		loc[j] = temp;
	}

	static class Location implements Comparable<Location> {
		int r;
		int c;

		public Location(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Location o) {
			return this.r != o.r ? this.r - o.r : this.c - o.c;
		}

	}

//	static String str = "3\r\n" + "5\r\n" + "0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + "6\r\n"
//			+ "88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\r\n" + "10\r\n"
//			+ "39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36";
}
