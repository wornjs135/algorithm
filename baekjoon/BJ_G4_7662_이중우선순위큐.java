package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_G4_7662_이중우선순위큐 {
	
	static int MAX;
	static int MIN;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < T; i++) {
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			Deque<Integer> dq = new ArrayDeque<>();
			TreeMap<Integer, Integer> map = new TreeMap<>();
						
			int k = Integer.parseInt(in.readLine());
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(in.readLine());
				String oper = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if(oper.equals("I")) {
					if (MAX <= number) {
						dq.offerLast(number);
					} else if (MIN >= number) {
						dq.offerFirst(number);
					}
				} else {
					
				}
			}
			
			
		}
		
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		in.close();
	}
	
	static String str = "2\r\n" + 
			"7\r\n" + 
			"I 16\r\n" + 
			"I -5643\r\n" + 
			"D -1\r\n" + 
			"D 1\r\n" + 
			"D 1\r\n" + 
			"I 123\r\n" + 
			"D -1\r\n" + 
			"9\r\n" + 
			"I -45\r\n" + 
			"I 653\r\n" + 
			"D 1\r\n" + 
			"I -642\r\n" + 
			"I 45\r\n" + 
			"I 97\r\n" + 
			"D 1\r\n" + 
			"D -1\r\n" + 
			"I 333";

}
