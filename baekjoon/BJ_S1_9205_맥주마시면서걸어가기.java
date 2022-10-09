package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기 {

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int distance;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			return this.distance - o.distance;
		}

	}
	
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(in.readLine()); // 편의점 개수
			StringTokenizer st = new StringTokenizer(in.readLine());

			Point house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			List<Point> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(in.readLine());

			Point festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < list.size(); i++) {
				list.get(i).distance = Math.abs(list.get(i).r - house.r) + Math.abs(list.get(i).c - house.c);
			}
			Collections.sort(list);
			list.add(festival);
		
			int beer = 20;

			String result = bfs(list, beer, house, festival, new boolean[n]);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}

	private static String bfs(List<Point> list, int beer, Point house, Point festival, boolean[] visited) {
		Queue<Point> q = new LinkedList<>();
		q.add(house);
		while (!q.isEmpty()) {
			Point curr = q.poll();
			if(getDistance(curr, festival) <= beer * 50) {
				return "happy";
			}
			
			for (int i = 0; i < n; i++) {
				if(!visited[i] && getDistance(curr, list.get(i)) <= beer * 50) {
					visited[i] = true;
					q.add(list.get(i));
				}
			}
		}
		
		return "sad";
	}
	
	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}

	static String str = "2\r\n" + "2\r\n" + "0 0\r\n" + "1000 0\r\n" + "1000 1000\r\n" + "2000 1000\r\n" + "2\r\n"
			+ "0 0\r\n" + "1000 0\r\n" + "2000 1000\r\n" + "2000 2000";

}
