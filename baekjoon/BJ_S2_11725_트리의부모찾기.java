package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_S2_11725_트리의부모찾기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();
		
		int N = Integer.parseInt(in.readLine());
		int[] hasParent = new int[N+1];
		
		tree.put(1, new LinkedList<>());
		
		for (int i = 0; i < N-1; i++) {
			String[] s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			if(tree.get(a) == null) {
				tree.put(a, new LinkedList<>());
				tree.get(a).add(b);
			}
			else {
				tree.get(a).add(b);
			}
				
			
			if(tree.get(b) == null) {
				tree.put(b, new LinkedList<>());
				tree.get(b).add(a);
			}
			else {
				tree.get(b).add(a);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int current = q.poll();
			while(!tree.get(current).isEmpty()) {
				int number = tree.get(current).poll();
				if (hasParent[number] == 0 && number != 1) {
					hasParent[number] = current;
					q.offer(number);
				}
			} 
		}
		
		for (int i = 2; i < hasParent.length; i++) {
			sb.append(hasParent[i]).append("\n");
		}
		System.out.println(sb);
	}

//	static String str = "7\r\n" + 
//			"1 6\r\n" + 
//			"6 3\r\n" + 
//			"3 5\r\n" + 
//			"4 1\r\n" + 
//			"2 4\r\n" + 
//			"4 7";
}
