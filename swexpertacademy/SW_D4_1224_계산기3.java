package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SW_D4_1224_계산기3 {

	static boolean isPriority(char c1, char c2) {
		if (c1 == '*') {
			if (c2 == '+')
				return true;
			else if (c2 == '(')
				return true;
			else
				return false;
		} else {
			if (c2 == '(')
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());

			char[] c = in.readLine().toCharArray();

			List<Character> post = new ArrayList<>();
			Stack<Character> oper = new Stack<>();

			// 후위 표기식 생성.
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '(' || c[i] == '+' || c[i] == '*') {
					if (c[i] == '+' || c[i] == '*') {
						if (oper.isEmpty() || isPriority(c[i], oper.peek())) {
							oper.push(c[i]);
						} else {
							while (!oper.isEmpty() && !isPriority(c[i], oper.peek())) {
								char temp = oper.pop();
								if (temp != '(') {
									post.add(temp);
								}
							}
							oper.push(c[i]);
						}
					} else {
						oper.push(c[i]);
					}

				} else if (c[i] == ')') {
					char temp = oper.pop();
					while (!oper.isEmpty() && temp != '(') {
						post.add(temp);
						temp = oper.pop();
					}
				} else {
					post.add(c[i]);
				}
			}

			while (!oper.isEmpty()) {
				post.add(oper.pop());
			}

			// 계산하기
			Stack<Integer> result = new Stack<>();

			for (int i = 0; i < post.size(); i++) {
				if (post.get(i) == '+') {
					result.add((result.pop()) + (result.pop()));
				} else if (post.get(i) == '*') {
					result.add((result.pop()) * (result.pop()));
				} else {
					result.add(post.get(i) - '0');
				}
			}
			sb.append(result.pop()).append("\n");
		}
		System.out.println(sb);
		in.close();
	}

//	static String str = "113\r\n"
//			+ "(9+(5*2+1)+(3*3*7*6*9*1*7+1+8*6+6*1*1*5*2)*4*7+4*3*8*2*6+(7*8*4*5)+3+7+(2+6+5+1+7+6+7*3*(6+2)+6+6)*2+4+2*2+4*9*3)";
//	static String str = "17\r\n"
//			+ "3+(4+5)*6+7";
}
