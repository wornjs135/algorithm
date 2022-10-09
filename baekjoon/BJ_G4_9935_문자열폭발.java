package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BJ_G4_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		String s = in.readLine();
		String boom = in.readLine();
		int boomSize = boom.length();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
			if (stack.size() >= boomSize) {
				boolean flag = true;
				for (int j = 0; j < boomSize; j++) {
					if(stack.get((stack.size()-boomSize) + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < boomSize; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.size() == 0) {
			sb.append("FRULA");
		} else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		
		System.out.println(sb);
		in.close();
	}

	static String str = "mirkovC4nizCC44\r\n" + 
			"C4";
	
}
