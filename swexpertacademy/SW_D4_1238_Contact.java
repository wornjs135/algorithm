package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_1238_Contact {

	static StringBuilder sb;
	static Map<Integer, List<Integer>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		sb = new StringBuilder();

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			boolean[][] adjMat = new boolean[101][101];

			st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adjMat[i][j] = true;
			}

			bfs(adjMat, new boolean[101], start);
			
			int max = 0;
			for (Integer cnt : map.keySet()) {
				if (max < cnt) {
					max = cnt;
				}
			}
			
			int max_num = 0;
			for (Integer num : map.get(max)) {
				if(max_num < num) {
					max_num =num;
				}
			}
			sb.append(max_num).append("\n");
		}

		System.out.println(sb);
		in.close();
	}

	public static void bfs(boolean[][] adjMat, boolean[] visited, int start) {

		Queue<Integer> q = new LinkedList<>();
		map = new HashMap<>();
		
		q.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 1; i <= qSize; i++) {
				int temp = q.poll();
				if (map.get(cnt) != null) {
					map.get(cnt).add(temp);
				} else {
					map.put(cnt, new ArrayList<>());
					map.get(cnt).add(temp);
				}
				
				for (int j = 1; j < 101; j++) {
					if(!visited[j] && adjMat[temp][j]) {
						q.offer(j);
						visited[j] = true;
					}
				}
			}
			cnt++;
		}
	}

//	static String str = "24 2\r\n" + 
//			"1 17 3 22 1 8 1 7 7 1 2 7 2 15 15 4 6 2 11 6 4 10 4 2\r\n" + 
//			
//			"300 42\r\n"
//			+ "42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23 34 74 65 42 12 54 69 48 45 63 58 38 60 24 42 30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 30 71 51 7 2 94 49 30 24 85 55 57 41 67 77 32 9 45 40 27 24 38 39 19 83 30 42 34 16 40 59 5 31 78 7 74 87 22 46 25 73 71 30 78 74 98 13 87 91 62 37 56 68 56 75 32 53 51 51 42 25 67 31 8 92 8 38 58 88 54 84 46 10 10 59 22 89 23 47 7 31 14 69 1 92 63 56 11 60 25 38 49 84 96 42 3 51 92 37 75 21 97 22 49 100 69 85 82 35 54 100 19 39 1 89 28 68 29 94 49 84 8 22 11 18 14 15 10 17 36 52 1 50 20 57 99 4 25 9 45 10 90 3 96 86 94 44 24 88 15 4 49 1 59 19 81 97 99 82 90 99 10 58 73 23 39 93 39 80 91 58 59 92 16 89 57 12 3 35 73 56 29 47 63 87 76 34 70 43 45 17 82 99 23 52 22 100 58 77 93 90 76 13 1 11 4 70 62 89 2 90 56 24 3 86 83 86 89 27 18 58 33 33 70 55 22 90";
}
