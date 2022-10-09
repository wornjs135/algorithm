package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_D4_3124_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge> {

		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int V;
	static int[] parents;
	static Edge[] edgeList;
	
	// 단위집합
	public static void makeSet() {
		parents = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	}
	
	// a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// a, b집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList);
			makeSet();
			
			long result = 0;
			int cnt = 0;
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt == V-1) break;
				}
			}
			for (int i = 1; i < V+1; i++) {
				findSet(i);
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}
	
	static String str = "1\r\n" + 
			"3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}
