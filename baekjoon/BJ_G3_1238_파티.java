package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G3_1238_파티 {
	
	static int max = Integer.MIN_VALUE;
	
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
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Node[] graph = new Node[N+1];
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from] = new Node(to, weight, graph[from]);
		}
		
		
		// 모든 점에 대해서 다익스트라 돌리기, i를 start점으로
		for (int i = 1; i < N+1; i++) {
			int end = X;
			int[] distance_sum = new int[N+1];
			
			Arrays.fill(visited, false);
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[i] = 0;
			
			int min = 0;
			int current = 0;
			for (int j = 1; j < N+1; j++) {
				min = Integer.MAX_VALUE;
				for (int k = 1; k < N+1; k++) {
					if(!visited[k] && distance[k] < min) {
						min = distance[k];
						current = k;
					}
				}
				
				visited[current] = true;
				if(current == end) break;
				
				for (Node temp = graph[current]; temp != null; temp = temp.link) {
					if(!visited[temp.to] &&
							distance[temp.to] > min+temp.weight) {
						distance[temp.to] = min+temp.weight;
					}
				}
			}
	
			distance_sum[i] = distance[end];
			
			
			// --------------------------------- 다익스트라 한번 더 -------------------------------------------
			int start = X;
			end = i;
			
			Arrays.fill(visited, false);
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[start] = 0;
			
			min = 0;
			current = 0;
			for (int j = 1; j < N+1; j++) {
				min = Integer.MAX_VALUE;
				for (int k = 1; k < N+1; k++) {
					if(!visited[k] && distance[k] < min) {
						min = distance[k];
						current = k;
					}
				}
				
				visited[current] = true;
				if(current == end) break;
				
				for (Node temp = graph[current]; temp != null; temp = temp.link) {
					if(!visited[temp.to] &&
							distance[temp.to] > min+temp.weight) {
						distance[temp.to] = min+temp.weight;
					}
				}			
			}

			distance_sum[i] += distance[end];	
			
			for (int j = 0; j < distance_sum.length; j++) {
				if (max < distance_sum[j]) {
					max = distance_sum[j];
					break;
				}
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		in.close();
	}

	static String str = "4 8 2\r\n" + 
			"1 2 4\r\n" + 
			"1 3 2\r\n" + 
			"1 4 7\r\n" + 
			"2 1 1\r\n" + 
			"2 3 5\r\n" + 
			"3 1 2\r\n" + 
			"3 4 4\r\n" + 
			"4 2 3";
	
}
