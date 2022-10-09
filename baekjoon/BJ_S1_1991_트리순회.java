package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S1_1991_트리순회 {

	static StringBuilder sb = new StringBuilder();
	
	static class ChildNode {
		char left;
		char right;
		
		public ChildNode(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));

		int N = Integer.parseInt(in.readLine());
		ChildNode[] tree = new ChildNode[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[parent-'A'] = new ChildNode(left, right);
		}
		

		dfsPre(tree, 'A');
		sb.append("\n");
		dfsIn(tree, 'A');
		sb.append("\n");
		dfsPost(tree, 'A');
		System.out.println(sb);
		in.close();
	}


	private static void dfsPre(ChildNode[] tree, char curr) {
		sb.append(curr);
		if(tree[curr-'A'].left != '.')
			dfsPre(tree, tree[curr-'A'].left);
		if(tree[curr-'A'].right != '.')
			dfsPre(tree, tree[curr-'A'].right);
	}
	
	private static void dfsIn(ChildNode[] tree, char curr) {
		if(tree[curr-'A'].left != '.')
			dfsIn(tree, tree[curr-'A'].left);
		sb.append(curr);
		if(tree[curr-'A'].right != '.')
			dfsIn(tree, tree[curr-'A'].right);
	}
	
	private static void dfsPost(ChildNode[] tree, char curr) {
		if(tree[curr-'A'].left != '.')
			dfsPost(tree, tree[curr-'A'].left);
		if(tree[curr-'A'].right != '.')
			dfsPost(tree, tree[curr-'A'].right);
		sb.append(curr);
	}


	static String str = "7\r\n" + "A B C\r\n" + "B D .\r\n" + "C E F\r\n" + "E . .\r\n" + "F . G\r\n" + "D . .\r\n"
			+ "G . .";
}
