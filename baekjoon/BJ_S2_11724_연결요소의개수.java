package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_11724_연결요소의개수 {
	
	static class Node {
		List<Integer> nearNodes = new ArrayList<>();
	}
	
	static int N, M, componentCnt;
	static Node[] nodes;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new Node[N+1];
		for (int i = 1; i < N+1; i++) {
			nodes[i] = new Node();
		}
		
		isVisited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			nodes[first].nearNodes.add(second);
			nodes[second].nearNodes.add(first);
		}
		
		componentCnt = 0;
		
		for (int i = 1; i < N+1; i++) {
			if(!isVisited[i]) {
				dfs(i);
				componentCnt++;
			}
		}
		
		System.out.println(componentCnt);
		in.close();
	}
	
	private static void dfs(int currNode) {
		if(isVisited[currNode]) {
			return;
		}
		
		isVisited[currNode] = true;
		
		List<Integer> nearNodes = nodes[currNode].nearNodes;
		for (int i = 0; i < nearNodes.size(); i++) {
			if(!isVisited[nearNodes.get(i)]) {
				dfs(nearNodes.get(i));
			}
		}
		
		
	}

	static String str = "6 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6";

}
