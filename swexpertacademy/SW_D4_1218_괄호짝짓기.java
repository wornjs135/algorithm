package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/swexpertacademy/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(in.readLine());
			char[] s = in.readLine().toCharArray();

			sb.append(isValid(s)).append("\n");
		}
		System.out.println(sb);
		in.close();
	}

	private static int isValid(char[] s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length; i++) {
			if (s[i] == '[' || s[i] == '{' || s[i] == '(' || s[i] == '<') {
				stack.add(s[i]);
			} else {
				if (stack.isEmpty()) {
					return 0;
				} else {
					char temp_s = '0';

					switch (s[i]) {
					case ']':
						temp_s = '[';
						break;
					case '>':
						temp_s = '<';
						break;
					case '}':
						temp_s = '{';
						break;
					case ')':
						temp_s = '(';
						break;

					}
					if (stack.pop() == temp_s) {
						continue;
					} else {
						return 0;
					}
				}
			}
		}
		return 1;
	}
}
