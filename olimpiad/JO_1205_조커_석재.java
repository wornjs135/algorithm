package olimpiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class JO_1205_조커_석재 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<Integer> set = new HashSet();
		int joker_cnt = 0;
		for (int i = 0; i < N; i++) {
			int card = sc.nextInt();
			if (card == 0) {
				joker_cnt++;
			} else {
				set.add(card);
			}
		}
		int max_dist=joker_cnt;
		for (int tmp : set) {
			int joker_card = joker_cnt;
			int num = tmp;
			int dist = 0;
			while (joker_card > 0 || set.contains(num)) {
				if (!set.contains(num)) {
					joker_card--;
				}
				dist++;
				num++;
			}
			max_dist = Math.max(max_dist, dist);
		}
		System.out.println(max_dist);
	}

	static String str = "7\r\n" + 
			"0 6 5 10 3 0 11";
	
}
