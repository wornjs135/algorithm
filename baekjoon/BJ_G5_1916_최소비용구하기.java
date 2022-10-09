package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1916_최소비용구하기 {
	
	static class Node {
		int to;
		int weight;
		Node link;
		
		public Node(int to, int weight, Node link) {
			super();
			this.to = to;
			this.weight = weight;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + ", link=" + link + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		Node[] graph = new Node[N+1];
		
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from] = new Node(to, weight, graph[from]);
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 1; j < N+1; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(current == end) break;
			
			for(Node temp = graph[current]; temp != null; temp = temp.link) {
				if(!visited[temp.to] && 
						distance[temp.to] > min + temp.weight) {
					distance[temp.to] = min + temp.weight;
				}
			}
			
		}
		
		sb.append(distance[end]);
		System.out.println(sb);
		in.close();
	}
	
	static String str = "5\r\n" + 
			"8\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"1 4 1\r\n" + 
			"1 5 10\r\n" + 
			"2 4 2\r\n" + 
			"3 4 1\r\n" + 
			"3 5 1\r\n" + 
			"4 5 3\r\n" + 
			"1 5";

}
