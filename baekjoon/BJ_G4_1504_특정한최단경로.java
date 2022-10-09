package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1504_특정한최단경로 {

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
		int E = Integer.parseInt(st.nextToken());
		Node[] graph = new Node[N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from] = new Node(to, weight, graph[from]);
			graph[to] = new Node(from, weight, graph[to]);
		}
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long result1 = 0;
		result1 += dijkstra(graph, 1, v1, N);
		result1 += dijkstra(graph, v1, v2, N);
		result1 += dijkstra(graph, v2, N, N);

		long result2 = 0;
		result2 += dijkstra(graph, 1, v2, N);
		result2 += dijkstra(graph, v2, v1, N);
		result2 += dijkstra(graph, v1, N, N);

		long result = 0;
		if (result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE)
			result = -1;
		else if (result1 >= Integer.MAX_VALUE && result2 < Integer.MAX_VALUE)
			result = result2;
		else if (result1 < Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE)
			result = result1;
		else
			result = Math.min(result1, result2);

		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	private static int dijkstra(Node[] graph, int start, int end, int N) {
		int[] distance = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		int min = 0;
		int current = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;
			if (current == end)
				break;

			for (Node temp = graph[current]; temp != null; temp = temp.link) {
				if (!visited[temp.to] && distance[temp.to] > min + temp.weight) {
					distance[temp.to] = min + temp.weight;
				}
			}

		}

		return distance[end];
	}

	static String str = "2 0\r\n" + 
			"1 2";

}
