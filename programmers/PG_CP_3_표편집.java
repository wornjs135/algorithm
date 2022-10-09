package programmers;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_CP_3_표편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
		String answer = "";

		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = null;
		for (int i = 0, size = cmd.length; i < size; i++) {
			st = new StringTokenizer(cmd[i]);
			String c = st.nextToken();
			if (c.equals("D")) {
				k += Integer.parseInt(st.nextToken());
			} else if (c.equals("U")) {
				k -= Integer.parseInt(st.nextToken());
			} else if (c.equals("C")) {
				stack.add(k);
				n--;
				if (k == n) {
					k -= 1;
				}
			} else if (c.equals("Z")) {
				n++;
				int temp = stack.pop();
				if (temp <= k)
					k++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("O");
		}
		
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			sb.insert(temp, "X");
		}

		answer = sb.toString();
		System.out.println(answer);
	}

}
