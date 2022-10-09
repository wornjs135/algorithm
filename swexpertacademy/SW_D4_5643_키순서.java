package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_5643_키순서 {
	public static int N, M, answer;
	public static boolean[] visited;
	public static int[] totalCnt;
	public static List<Integer>[] students;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			students = new ArrayList[N + 1];
			totalCnt = new int[N + 1];
			
			for (int i = 1; i <= N; ++i) {
				students[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i <= M; ++i) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				students[from].add(to);
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i <= N; ++i) {
				visited = new boolean[N + 1];
				q.offer(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					int x = q.poll();
					totalCnt[i]++;
					for (int j = 0; j < students[x].size(); ++j) {
						int y = students[x].get(j);
						if (visited[y]) {
							continue;
						}
						q.offer(y);
						visited[y] = true;
						totalCnt[y]++;
					}
				}
			}
			
			answer = 0;
			for (int i = 1; i <= N; ++i) {
				if (totalCnt[i] == N) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static String str = "1\r\n" + 
			"6\r\n" + 
			"6\r\n" + 
			"1 5\r\n" + 
			"3 4\r\n" + 
			"5 4\r\n" + 
			"4 2\r\n" + 
			"4 6\r\n" + 
			"5 2";
}