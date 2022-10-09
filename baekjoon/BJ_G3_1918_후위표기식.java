package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BJ_G3_1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		char[] expr = in.readLine().toCharArray();
		Stack<Character> oper = new Stack<>();
		
		for (char c : expr) {
			if(isOperation(c)) {
				if(oper.empty()) {
					oper.push(c);
				} else {
					if(c == '(') {
						oper.push(c);
					} else if (c == ')'){
						while(oper.peek() != '(') {
							sb.append(oper.pop());
						}
						oper.pop();
					} else {
						char temp = oper.peek();
						if(priority(c) >= priority(temp)) {
							while(!oper.isEmpty() && priority(c) >= priority(temp)) {
								sb.append(oper.pop());
								if(!oper.isEmpty()) {
									temp = oper.peek();
								}
							}
							oper.push(c);
						} else {
							oper.push(c);
						}
					}
				}
				
			} else {
				sb.append(c);
			}
		}
		
		
		while(!oper.empty()) {
			sb.append(oper.pop());
		}
		
		System.out.println(sb);
		in.close();
	}

	private static int priority(char c) {
		if (c == '*' || c=='/') {
			return 1;
		} else if (c == '+' || c=='-'){
			return 2;
		} else {
			return 3;
		}
	}

	private static boolean isOperation(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
			return true;
		}
		return false;
	}

	static String str = "A+B*C-D/E";
	
}
