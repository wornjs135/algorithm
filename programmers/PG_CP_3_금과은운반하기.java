package programmers;

import java.util.stream.IntStream;

public class PG_CP_3_금과은운반하기 {

	public static void main(String[] args) {
		int a = 90;
		int b = 500;
		int[] g = { 70, 70, 0 };
		int[] s = { 0, 0, 500 };
		int[] w = { 100, 100, 2 };
		int[] t = { 4, 8, 1 };
		long answer = -1;

		long left = 0;
		long right = (long) (4 * 1e14 + 1e5);

		while (left <= right) {
			long mid = (left + right) / 2;
			long total_gold = 0;
			long total_silver = 0;
			long total_gold_silver = 0;

			for (int i = 0, size = g.length; i < size; i++) {
				long round_trip_cnt = mid / (t[i] * 2);
				if (mid % (t[i] * 2) >= t[i]) 
					round_trip_cnt++;
				long max_take_weight = w[i] * round_trip_cnt;
				
				total_gold += Math.min(g[i], max_take_weight);
				total_silver += Math.min(s[i], max_take_weight);
				total_gold_silver += Math.min(g[i] + s[i], max_take_weight);	
			}
			
			if(a <= total_gold && b <= total_silver && (a+b) <= total_gold_silver) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

}
