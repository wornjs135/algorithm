package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW_D4_3289_서로소집합 {
	
	static int n;
	static int[] parents;
	
	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[n+1];
		// 부모노드를 자신으로 세팅
		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합(대표자) 찾기
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// a b 두집합 합치기
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
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (oper == 1) {
					if(findSet(a) == findSet(b))
						sb.append(1);
					else
						sb.append(0);
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}
	
//	static String str = "1\r\n" + 
//			"7 8\r\n" + 
//			"0 1 3\r\n" + 
//			"1 1 7\r\n" + 
//			"0 7 6\r\n" + 
//			"1 7 1\r\n" + 
//			"0 3 7\r\n" + 
//			"0 4 2\r\n" + 
//			"0 1 1\r\n" + 
//			"1 1 1";

}
