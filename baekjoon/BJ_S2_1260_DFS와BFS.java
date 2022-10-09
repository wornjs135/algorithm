package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1260_DFS와BFS {
	
	static StringBuilder sb;
	
	public static void dfs(int[][] adjMatrix, int current, boolean[] visited, int N) {
		
		visited[current] = true;
		sb.append(current).append(" ");
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i] && adjMatrix[current][i] == 1) {
				dfs(adjMatrix, i, visited, N);
			}
		}
	}
	
	public static void bfs(int[][] adjMatrix, int start, boolean[] visited, int N) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");
			
			for (int i = 1; i < N+1; i++) {
				if(!visited[i] && adjMatrix[current][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			adjMatrix[first][second] = 1;
			adjMatrix[second][first] = 1;
		}
		
		dfs(adjMatrix, V, new boolean[N+1], N);
		sb.append("\n");
		bfs(adjMatrix, V, new boolean[N+1], N);
		
		System.out.println(sb);
		in.close();
	}
	
	

//	static String str = "5 5 3\r\n" + 
//			"5 4\r\n" + 
//			"5 2\r\n" + 
//			"1 2\r\n" + 
//			"3 4\r\n" + 
//			"3 1";

}
