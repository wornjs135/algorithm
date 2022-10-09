package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PG_CP_3_셔틀버스 {
	public static void main(String[] args) {
		int n = 10;
		int t = 60;
		int m = 45;
		String[] timetable = { "23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59" };
		String answer = "";

		Arrays.sort(timetable);

		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < timetable.length; i++) {
			q.offer(timetable[i]);
		}
		Stack<String> stack = null;

		int currHour = 9;
		int currMin = 0;

		for (int i = n; i > 0; i--) {
			stack = new Stack<>();
			int passenger = 0;
			while (!q.isEmpty() && passenger < m
					&& (Integer.parseInt(q.peek().substring(0, 2)) < currHour
							|| (Integer.parseInt(q.peek().substring(0, 2)) == currHour
									&& Integer.parseInt(q.peek().substring(3, 5)) <= currMin))) {
				stack.add(q.poll());
				passenger++;
			}

			if (currMin + t > 59) {
				currHour++;
				currMin = 0;
			} else {
				currMin += t;
			}
		}

		currMin -= t;
		if (currMin < 0) {
			currHour--;
			currMin = 60 - t;
		}

		StringBuilder sb = new StringBuilder();
		if (stack.size() < m) {
			sb.append(currHour < 10 ? "0" + currHour : currHour).append(":")
					.append(currMin < 10 ? "0" + currMin : currMin);
			answer = sb.toString();
		} else {
			String temp = stack.peek();
			int tempHour = Integer.parseInt(temp.substring(0, 2));
			int tempMin = Integer.parseInt(temp.substring(3, 5));
			tempMin--;
			if (tempMin == -1) {
				tempHour--;
				tempMin = 59;
			}
			sb.append(tempHour < 10 ? "0" + tempHour : tempHour).append(":")
					.append(tempMin < 10 ? "0" + tempMin : tempMin);
			answer = sb.toString();
		}

		System.out.println(answer);
	}
}
