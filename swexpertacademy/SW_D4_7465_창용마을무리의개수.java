package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SW_D4_7465_창용마을무리의개수 {
	
	static int N;
	static int[] parents;
	
	// 단위 집합 생성
	public static void makeSet() {
		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	// a가 속한 집합(대표자) 찾기
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// a b 집합 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot)
			parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Map<Integer, List<Integer>> count = new HashMap<>();
			for (int i = 1; i < N+1; i++) {
				findSet(i);
				if(count.get(parents[i]) != null) {
					count.get(parents[i]).add(i);
				} else {
					count.put(parents[i], new ArrayList<>());
					count.get(parents[i]).add(i);
				}
			}
			
			int result = 0;
			for (Integer i : count.keySet()) {
				result++;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		in.close();
	}

//	static String str = 
//			"2\r\n" + 
//			"6 5\r\n" + 
//			"1 2\r\n" + 
//			"2 5\r\n" + 
//			"5 1\r\n" + 
//			"3 4\r\n" + 
//			"4 6\r\n" + 
//			"6 8\r\n" + 
//			"1 2\r\n" + 
//			"2 5\r\n" + 
//			"5 1\r\n" + 
//			"3 4\r\n" + 
//			"4 6\r\n" + 
//			"5 4\r\n" + 
//			"2 4\r\n" + 
//			"2 3";
	
}
