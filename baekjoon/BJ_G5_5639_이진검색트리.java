package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_G5_5639_이진검색트리 {
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public Node(int num, Node left, Node right) {
			super();
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));

		String s = null;
		List<Integer> nodes = new ArrayList<>();
		while((s = in.readLine()) != null) {
			nodes.add(Integer.parseInt(s));
		}
		Node root = new Node(nodes.get(0));
		
		for (int i = 1, size = nodes.size(); i < size; i++) {
			makeTree(nodes.get(i), root);
		}
		
		postOrder(root);
		
		System.out.println(sb);
		in.close();
	}

	private static void postOrder(Node currNode) {
		if(currNode.left != null)
			postOrder(currNode.left);
		if(currNode.right != null)
			postOrder(currNode.right);
		sb.append(currNode.num).append("\n");
	}

	private static void makeTree(int addNode, Node currNode) {
		if(addNode < currNode.num) {
			if(currNode.left == null) {
				currNode.left = new Node(addNode);
			} else {
				makeTree(addNode, currNode.left);
			}
		} else {
			if(currNode.right == null) {
				currNode.right = new Node(addNode);
			} else {
				makeTree(addNode, currNode.right);
			}
		}
	}

	static String str = "50\r\n" + 
			"30\r\n" + 
			"24\r\n" + 
			"5\r\n" + 
			"28\r\n" + 
			"45\r\n" + 
			"98\r\n" + 
			"52\r\n" + 
			"60";
}
