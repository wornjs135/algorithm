package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_CP_2_문자열압축 {

	public static void main(String[] args) {
		String s;
		int answer = 0;
		s = "aabbaccc";
		int min = 999999;

		int size = s.length() % 2 == 0 ? s.length() / 2 : (s.length() / 2) + 1;
		for (int i = 1; i <= size; i++) { // 1개로 쪼개기, 2개로 쪼개기, ...., 문자열 크기의 반만큼으로 쪼개기
			Queue<String> q = new LinkedList<>();
			int startIndex = 0; // 시작 인덱스
			int lastIndex = startIndex + i; // 끝 인덱스
			while (lastIndex <= s.length()) { // 끝 인덱스가 문자열의 끝까지 갈때까지 쪼갠걸 큐에 저장.
				q.offer(s.substring(startIndex, lastIndex));
				System.out.println("쪼개기1:" + s.substring(startIndex, lastIndex));
				startIndex += i;
				lastIndex = startIndex + i;
			}

			q.offer(s.substring(startIndex, s.length())); //(위 while문에서 startIndex가 정확히 문자열끝이라면 공백이 큐에 추가됨.)
			System.out.println("쪼개기2:" + s.substring(startIndex, s.length()));
			System.out.println(startIndex);
			if (startIndex != s.length()) { //startIndex가 문자열끝보다 전에 있으면 공백이 안들어가서 따로 추가해줌.
				q.offer("");
			}

			StringBuilder sb = new StringBuilder();
			int cnt = 1;
			String temp = q.poll();
			while (!q.isEmpty()) {
				if (temp.equals(q.peek())) {
					cnt++;
					temp = q.poll();
				} else {
					sb.append(cnt == 1 ? "" : cnt).append(temp);
					temp = q.poll();
					cnt = 1;
				}
			}

			if (min > sb.length()) {
				min = sb.length();
			}
			System.out.println("쪼개고 완성:" + sb);
		}
		answer = min;
		System.out.println("정답:" + answer);
	}

}
