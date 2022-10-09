package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1043_거짓말 {

	static int parents[];
	static boolean know[];
	static int knowPeople;

	static void makeSet(int N) {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		know = new boolean[N + 1];
		makeSet(N);

		int M = Integer.parseInt(st.nextToken()); // 파티 수
		

		st = new StringTokenizer(in.readLine()); // 아는 사람 수와 번호
		int knowPeopleCnt = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			knowPeople = Integer.parseInt(st.nextToken());
			know[knowPeople] = true;

		}

		int[][] people = new int[M][];

		// 파티 오는 사람들
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			int temp1 = Integer.parseInt(st.nextToken());
			people[i] = new int[cnt];
			people[i][0] = temp1;
			int j = 1;
			while (st.hasMoreTokens()) {
				int temp2 = Integer.parseInt(st.nextToken());
				people[i][j] = temp2;
				j++;
				union(temp1, temp2);
				for (int k = 1; k < know.length; k++) {
					if(!know[k] && (know[temp1] || know[temp2])) {
						if (findSet(k) == findSet(temp1)) {
							know[k] = true;
						} else if (findSet(k) == findSet(temp2)) {
							know[k] = true;
						}
						
					}
				}
			}

		}

//		for (int i = 1; i < N + 1; i++) {
////			if (know[findSet(i)]) {
////				know[i] = true;
////			}
////			if (know[i]) {
////				know[findSet(i)] = true;
////			}
//			for (int j = 1; j < N+1; j++) {
//				int temp1 = findSet(i);
//				int temp2 = findSet(j);
//				System.out.println(i + " " + j);
//				if(temp1 == temp2 && (know[i] || know[j])) {
//					know[temp1] = true;
//					know[temp2] = true;
//					
//				}
//			}
//		}

		int result = 0;
		for (int i = 0; i < people.length; i++) {
			boolean flag = false;
			for (int j = 0; j < people[i].length; j++) {
				if (know[people[i][j]]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				result++;
		}

//		print(people);
		System.out.println(Arrays.toString(know));
		System.out.println(Arrays.toString(parents));

		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	static void print(int[][] party) {
		for (int i = 0; i < party.length; i++) {
			for (int j = 0; j < party[i].length; j++) {
				System.out.print(party[i][j]);
			}
			System.out.println();
		}
	}

	static String str = "3 4\r\n" + 
			"1 3\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"2 1 2\r\n" + 
			"3 1 2 3";

}
