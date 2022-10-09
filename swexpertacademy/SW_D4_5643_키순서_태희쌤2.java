package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_5643_키순서_태희쌤2 {

	static int N;
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());

			adjMatrix = new int[N + 1][N + 1];
			int a, b;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine()); // a b: a보다 b가 크다
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}

			int answer = 0;

			for (int i = 1; i < N + 1; i++) {
				gtCnt = 0;
				ltCnt = 0;
				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);
				if (gtCnt + ltCnt == N - 1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static int gtCnt = 0;
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i < N + 1; i++) { // 모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
			if (adjMatrix[cur][i] != 0 && !visited[i]) {
				gtCnt++;
				gtDFS(i, visited);
			}
		}
	}

	static int ltCnt = 0;
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i < N + 1; i++) { // 모든 학생 들여다 보며 자신보다 키가 작은 학생 따라 탐색
			if (adjMatrix[i][cur] != 0 && !visited[i]) {
				ltCnt++;
				ltDFS(i, visited);
			}
		}
	}
}
