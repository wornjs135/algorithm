package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_S5_1158_요세푸스문제_ArrayList {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		List<Integer> list = new ArrayList<>();

		String[] s = in.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int idx = -1;
		while (true) {
			for (int i = 0; i < K; i++) {
				idx++;
				if (idx >= list.size()) {
					idx = 0;
				}
			}
			int remove = list.remove(idx--);
			sb.append(remove).append(", ");

			if (list.size() == 1) {
				sb.append(list.get(0));
				break;
			}
		}

		sb.append(">");
		System.out.println(sb);
		in.close();
	}

//	static String str = "7 3";
}
