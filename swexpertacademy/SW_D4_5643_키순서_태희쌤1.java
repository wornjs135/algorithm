package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_5643_키순서_태희쌤1 {

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
				if (gtBFS(i, new boolean[N + 1]) + ltBFS(i, new boolean[N + 1]) == N - 1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static int gtBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i < N + 1; i++) { // 모든 학생 들여다 보며 자신보다 키가 큰 학생 따라 탐색
				if (adjMatrix[cur][i] != 0 && !visited[i]) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}

	static int ltBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i < N + 1; i++) { // 모든 학생 들여다 보며 자신보다 키가 작은 학생 따라 탐색 (인접행렬에서 열로 탐색)
				if (adjMatrix[i][cur] != 0 && !visited[i]) {
					cnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return cnt;
	}

}
