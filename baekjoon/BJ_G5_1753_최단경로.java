package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1753_최단경로 {

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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Node[] list = new Node[V + 1];
//		int[][] adjMatrix = new int[V + 1][V + 1];

		// 시작지점
		int K = Integer.parseInt(in.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from] = new Node(to, weight, list[from]);
//			adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer
//					.parseInt(st.nextToken());
		}

		int[] distance = new int[V + 1]; // 출발지에서 자신으로 오는 최소 비용
		boolean[] visited = new boolean[V + 1]; // 최소비용 확정 여부

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[K] = 0; // 시작지점 0으로

		for (int i = 0; i < V; i++) {
			// 1단계: 최소 비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;

			// 2단계: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용 고려
			for (Node temp = list[current]; temp != null; temp = temp.link) {
				if (!visited[temp.to] && distance[temp.to] > distance[current] + temp.weight) {
					distance[temp.to] = distance[current] + temp.weight;
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}

		System.out.println(sb);
		in.close();
	}

//	static String str = "5 6\r\n" + "1\r\n" + "5 1 1\r\n" + "1 2 2\r\n" + "1 3 3\r\n" + "2 3 4\r\n" + "2 4 5\r\n"
//			+ "3 4 6";
	static String str = "5 8\r\n" + "1\r\n" + "1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"1 4 1\r\n" + 
			"1 5 10\r\n" + 
			"2 4 2\r\n" + 
			"3 4 1\r\n" + 
			"3 5 1\r\n" + 
			"4 5 3\r\n";

}
