package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S1_1697_숨바꼭질 {
	
	static class Point implements Comparable<Point>{
		int curr;
		int moveCnt;
		
		public Point(int curr, int moveCnt) {
			super();
			this.curr = curr;
			this.moveCnt = moveCnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.moveCnt - o.moveCnt;
		}
	}
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bfs();
		
		in.close();
	}
	
	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(N, 0));
		boolean[] isVisited = new boolean[100001];
		isVisited[N] = true;
		
		
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			
			if(temp.curr == M) {
				System.out.println(temp.moveCnt);
				System.exit(0);
			}
			
			int pre = temp.curr - 1;
			int next = temp.curr + 1;
			int jump = temp.curr * 2;
			
			if(pre >= 0 && !isVisited[pre]){
				pq.add(new Point(pre, temp.moveCnt+1));
				isVisited[pre] = true;
			}
			if(next <= 100000 && !isVisited[next]){
				pq.add(new Point(next, temp.moveCnt+1));
				isVisited[next] = true;
			}
			if(jump <= 100000 && !isVisited[jump]) {
				pq.add(new Point(jump, temp.moveCnt+1));
				isVisited[jump] = true;
			}
			
		}
	}
	
	static String str = "6 0";
}
