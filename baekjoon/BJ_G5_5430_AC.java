package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class BJ_G5_5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();;
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String command = in.readLine();
			int n = Integer.parseInt(in.readLine());
			String numbers = in.readLine();
			
			numbers = numbers.substring(1, numbers.length());
			numbers = numbers.substring(0, numbers.length()-1);
			String[] splited = numbers.split(",");

			ArrayDeque<String> dq = new ArrayDeque<>();
			for(String s : splited) {
				if(!s.equals(""))
					dq.add(s);
			}
			
			boolean fromFirst = true;
			int reverseCnt = 0;
			boolean isError = false;
			for (int j = 0; j < command.length(); j++) {
				char c = command.charAt(j);
				if (c == 'R') {
					fromFirst = !fromFirst;
					reverseCnt++;
				} else {
					if(dq.size() == 0) {
						isError = true;
						sb.append("error").append("\n");
						break;
					}
					if (fromFirst) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			
			if(!isError) {
				if(reverseCnt % 2 != 0) {
					sb.append("[");
					Iterator<String> it = dq.descendingIterator();
					while(it.hasNext()) {
						sb.append(it.next()).append(",");
					}
					if(dq.size() != 0) {
						sb.setLength(sb.length()-1);
					}
					sb.append("]").append("\n");
				} else {
					sb.append("[");
					Iterator<String> it = dq.iterator();
					while(it.hasNext()) {
						sb.append(it.next()).append(",");
					}
					if(dq.size() != 0) {
						sb.setLength(sb.length()-1);
					}
					sb.append("]").append("\n");
				}
				
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		in.close();
		
		/* 
		 * 반례: 함수를 다 돌리고 난 후, dq의 사이즈가 0일때 [] <- 이렇게 출력이 되어야 함
		 * */
	}

	
	static String str = "1\r\n" + 
			"R\r\n" + 
			"5\r\n" + 
			"[1,9,3,7,5]";
}
