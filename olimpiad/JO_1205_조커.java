package olimpiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JO_1205_조커 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int joker_cnt = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				joker_cnt++;
			} else {
				set.add(num);
			}
		}
		
		int max = joker_cnt;
		
		for (Integer number : set) {
			int temp = number;
			int joker = joker_cnt;
			int dist = 0;
			while (joker > 0 || set.contains(temp)) {
				if (!set.contains(temp)) {
					joker--;
				}
				temp++;
				dist++;
			}
			if(max < dist)
				max = dist;
		}
		
		sb.append(max);
		System.out.println(sb);
		in.close();
	}

//	static String str = "7\r\n" + 
//			"0 6 5 10 3 0 11";
	
}
