package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1068_트리 {

	static int cnt;
	static int K;

	static class Node {
		int no;
		List<Node> child = new ArrayList();

		public Node(int no) {
			super();
			this.no = no;
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", child=" + child + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Node[] graph = new Node[N];
		Node root = null;

		for (int i = 0; i < N; i++) {
			graph[i] = new Node(i);
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == -1) {
				root = graph[i];
			} else {
				graph[temp].child.add(graph[i]);
			}

		}
		K = Integer.parseInt(in.readLine());
		if(K == root.no) {
			System.out.println(0);
			System.exit(0);
		}

		cnt = 0;

		graph[K].child = new ArrayList<>();
//		graph[K] = null;
//		System.out.println(graph[K].child);

		for (Node node : root.child) {
			if(node.no == K) {
				root.child.remove(node);
				break;
			}
		}
		
		if(root.child.size() == 0) {
			cnt++;
		} else {
			for (Node node : root.child) {
				dfs(node);
			}
		}
		

//		for (int i = 0; i < graph.length; i++) {
//			System.out.println(graph[i]);
//		}

//		if (cnt == 0)
//			cnt = 0;
//		else
//			cnt -= 1;
		sb.append(cnt);
		System.out.println(sb);
		in.close();
	}

	private static void dfs(Node node) {
//		System.out.println("node.child: " + node.child.size());
		for (Node temp : node.child) {
//			System.out.println("temp.no:" + temp.no);
			if (temp.no == K) {
//				System.out.println(temp.no);
				node.child.remove(temp);
				break;
			}
		}

		if (node.child.size() == 0) {
//			System.out.println("여기?" + node.no);
			if (node.no != K) {
//				System.out.println("여기" + node.no);
				cnt++;
			}

			return;
		}

		for (Node temp : node.child) {
			if (temp.no != K)
				dfs(temp);
		}
	}

	static String str = "5\r\n" + 
			"-1 0 0 1 1\r\n" + 
			"0";

}
