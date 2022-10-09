package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16928_뱀과사다리게임 {

	static int[] count = new int[101];
	static int[] ladder = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(in.readLine());
			ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		count[1] = 0;
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == 100) {
				System.out.println(count[curr]);
				System.exit(0);
			}
			
			for (int i = 1; i <= 6; i++) {
				int x = curr + i;
				if (100 < x) continue;
				if (visited[x]) continue;
				visited[x] = true;
				
				if(ladder[x] != 0) { // 사다리거나 뱀일때
					if(!visited[ladder[x]]) {
						q.offer(ladder[x]);
						visited[ladder[x]] = true;
						count[ladder[x]] = count[curr] + 1;
					}
					
				} else {
					q.offer(x);
					count[x] = count[curr] + 1;
				}
			}
			
		}


		System.out.println(sb);
		in.close();
	}

	static String str = "3 7\r\n" + 
			"32 62\r\n" + 
			"42 68\r\n" + 
			"12 98\r\n" + 
			"95 13\r\n" + 
			"97 25\r\n" + 
			"93 37\r\n" + 
			"79 27\r\n" + 
			"75 19\r\n" + 
			"49 47\r\n" + 
			"67 17";

}
