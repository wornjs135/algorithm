package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_모의역량테스트_4012_요리사 {

	static int N;
	static int min = Integer.MAX_VALUE;

	private static void combination(int cnt, int start, int[][] synergy, boolean[] choice) {
		if (cnt == N / 2) {
			int minus = calc(choice, synergy);
			if(min > minus) min = minus;
			return;
		}

		for (int i = start, size = synergy.length; i < size; i++) {
			choice[i] = true;
			combination(cnt + 1, i + 1, synergy, choice);
			choice[i] = false;
		}
	}

	private static int calc(boolean[] choice, int[][] synergy) {
		List<Integer> dishA = new ArrayList<>();
		List<Integer> dishB = new ArrayList<>();

		for (int i = 0, size = choice.length; i < size; i++) {
			if (choice[i])
				dishA.add(i);
			else
				dishB.add(i);
		}
		
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i==j) continue;
				sumA += synergy[dishA.get(i)][dishA.get(j)];
				sumB += synergy[dishB.get(i)][dishB.get(j)];
			}
		}
		
		return Math.abs(sumA - sumB);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			int[][] synergy = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0, 0, synergy, new boolean[N]);
			sb.append(min).append("\n");
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb);
		in.close();
	}

//	static String str = "3\r\n" + 
//			"4\r\n" + 
//			"0 5 3 8\r\n" + 
//			"4 0 4 1\r\n" + 
//			"2 5 0 3\r\n" + 
//			"7 2 3 0\r\n" + 
//			"4\r\n" + 
//			"0 7 1 1\r\n" + 
//			"7 0 6 2\r\n" + 
//			"1 1 0 2\r\n" + 
//			"10 1 9 0\r\n" + 
//			"6\r\n" + 
//			"0 37 26 52 77 20\r\n" + 
//			"32 0 15 26 75 16\r\n" + 
//			"54 33 0 79 37 90\r\n" + 
//			"92 10 66 0 92 3\r\n" + 
//			"64 7 89 89 0 21\r\n" + 
//			"80 49 94 68 5 0";

}
