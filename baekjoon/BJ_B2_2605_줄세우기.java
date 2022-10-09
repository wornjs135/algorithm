package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BJ_B2_2605_줄세우기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[] jebi = new int[N];
		
		String[] s = in.readLine().split(" ");
		for (int i = 0; i < s.length; i++) {
			jebi[i] = Integer.parseInt(s[i]);
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		
		int person = 1;
		for (int i = 0; i < N; i++) {
			list.add(jebi[i], person++);
		}
		
		for (int i = (list.size()-1); i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
		in.close();
	}
	
	static String str = "5\r\n" + 
			"0 1 1 3 2";
}
