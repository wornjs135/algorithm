package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D4_5643_키순서_태희쌤3 {

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

			// 모든 쌍의 관계를 파악
			for (int k = 1; k < N+1; k++) { // 경유학생
				for (int i = 1; i < N+1; i++) { // 출발학생(자신과 다른 학생과의 관계를 알고 싶은 학생)
					if(i==k || adjMatrix[i][k] == 0) continue;
					for (int j = 1; j < N+1; j++) { // 고려(도착)학생(다른학생)
						if(adjMatrix[i][j] == 1) continue;
						if(adjMatrix[k][j] == 1) {
							adjMatrix[i][j] = 1;
						}
					}
				}
			}
			// 알수 있는 모든 쌍의 관계가 반영되어 있음
			
			// 자신보다 큰,작은 학생 수 카운트
			// 0행과 0열 빈칸을 이용해 결과 저장해놓기
			for (int i = 1; i <N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
					adjMatrix[0][i] += adjMatrix[i][j];
				}
			}
			
			int answer = 0;
			for (int i = 1; i < N + 1; i++) {
				if (adjMatrix[i][0] + adjMatrix[0][i] == N - 1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
