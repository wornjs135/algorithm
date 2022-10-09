package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G3_1167_트리의지름 {
	
	static int max = Integer.MIN_VALUE;
	static int longVertex = 0;
	
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
		Node[] tree = new Node[N+1];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				tree[vertex] = new Node(to, weight, tree[vertex]);
			}
		}	
		
		dfs(tree, 1, new boolean[N+1], 0);
		dfs(tree, longVertex, new boolean[N+1], 0);
		
		sb.append(max);
		System.out.println(sb);
		in.close();
	}
	
	private static void dfs(Node[] tree, int current, boolean[] visited, int sum) {
		if(max < sum) {
			max = sum;
			longVertex = current;
		}
		visited[current] = true;
		
		for (Node temp = tree[current]; temp != null; temp = temp.link) {
			if(!visited[temp.to]) {
				dfs(tree, temp.to, visited, sum + temp.weight);
			}
		}
	}

	static String str = "5\r\n" + 
			"1 3 2 -1\r\n" + 
			"2 4 4 -1\r\n" + 
			"3 1 2 4 3 -1\r\n" + 
			"4 2 4 3 3 5 6 -1\r\n" + 
			"5 4 6 -1";

}
