package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D3_1225_암호생성기 {
	
//	static String st = "1\r\n" + 
//			"9550 9556 9550 9553 9558 9551 9551 9551";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int test_case = Integer.parseInt(in.readLine());
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			Queue<Integer> q = new LinkedList<>();
			
			while(st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean exit = false;
			while (!exit) {
				for (int i = 1; i <= 5; i++) {
					int temp = q.poll();
					if (temp - i <= 0) {
						temp = 0;
						exit = true;
						q.offer(temp);
						break;
					}
					q.offer(temp-i);
				}
			}
			
			Iterator iter = q.iterator();
			while(iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}

}
