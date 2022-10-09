package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BJ_S3_1406_에디터_ListIterator {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator();

		char[] c = in.readLine().toCharArray();
		for (int i = 0; i < c.length; i++) {
			iter.add(c[i]);
		}

		int M = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < M; i++) {
			
			String s = in.readLine();
			
			if (s.charAt(0) == 'P') {
				StringTokenizer st = new StringTokenizer(s);
				st.nextToken();
				iter.add(st.nextToken().charAt(0));
			} else if (s.charAt(0) == 'L') {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (s.charAt(0) == 'D') {
				if (iter.hasNext()) {
					iter.next();
				}
			} else if (s.charAt(0) == 'B') {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}

		while(iter.hasPrevious()) {
			iter.previous();
		}
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb);
		in.close();
	}

//	static String st = "abcd\r\n" + 
//			"3\r\n" + 
//			"P x\r\n" + 
//			"L\r\n" + 
//			"P y";

}
