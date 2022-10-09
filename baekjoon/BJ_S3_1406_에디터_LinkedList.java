package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S3_1406_에디터_LinkedList {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();
		char[] c = in.readLine().toCharArray();
		for (int i = 0; i < c.length; i++) {
			list.add(c[i]);
		}

		int M = Integer.parseInt(in.readLine());
		int cursor = list.size();
		for (int i = 0; i < M; i++) {
			
			String s = in.readLine();
			
			if (s.charAt(0) == 'P') {
				StringTokenizer st = new StringTokenizer(s);
				st.nextToken();
				list.add(cursor, st.nextToken().charAt(0));
				cursor++;
			} else if (s.charAt(0) == 'L') {
				cursor--;
				if (cursor < 0) {
					cursor = 0;
				}
			} else if (s.charAt(0) == 'D') {
				cursor++;
				if (cursor > list.size()) {
					cursor = list.size();
				}
			} else if (s.charAt(0) == 'B') {
				if (cursor != 0) {
					list.remove(cursor-1);
					cursor--;
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb);
		in.close();
	}

	static String st = "dmih\r\n" + 
			"11\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"P x\r\n" + 
			"L\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"P y\r\n" + 
			"D\r\n" + 
			"D\r\n" + 
			"P z";
}
