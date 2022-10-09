package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_2493_탑 {

//	static String st = "5\r\n" + "6 9 5 7 4";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		Stack<Pair> stack = new Stack<>();

		int idx = 1;
		while (st.hasMoreTokens()) {
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new Pair(idx, Integer.parseInt(st.nextToken())));
			} else {
				int next = Integer.parseInt(st.nextToken());
				if (next > stack.peek().height && (!stack.isEmpty())) {
					while ((!stack.isEmpty()) && next > stack.peek().height) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						sb.append(0).append(" ");
						stack.push(new Pair(idx, next));
					} else {
						sb.append(stack.peek().idx).append(" ");
						stack.push(new Pair(idx, next));
					}
				} else if (next < stack.peek().height) {
					sb.append(stack.peek().idx).append(" ");
					stack.push(new Pair(idx, next));
				}
				
			}
			idx++;
		}
		System.out.println(sb);
	}

	static class Pair {
		int idx;
		int height;

		Pair(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
}
