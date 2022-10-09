package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_S5_1158_요세푸스문제_Queue {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		Queue<Integer> queue = new LinkedList<Integer>();

		String[] s = in.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb);
		in.close();
	}
	
//	static String str = "7 3";
}
