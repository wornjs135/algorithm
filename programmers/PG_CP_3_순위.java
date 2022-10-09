package programmers;

public class PG_CP_3_순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		int answer = 0;

		int INF = n * n + 1; // ?
		int[][] floyd = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				floyd[i][j] = INF;
			}
			floyd[i][i] = 0;
		}

		for (int i = 0; i < results.length; i++) {
			floyd[results[i][0]][results[i][1]] = 1;
		}
		
		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				if (k == i)
					continue;
				for (int j = 1; j < n + 1; j++) {
					if (i == j || k == j)
						continue;
					if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
						floyd[i][j] = floyd[i][k] + floyd[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i < floyd.length; i++) {
			for (int j = 1; j < floyd.length; j++) {
				System.out.print(floyd[i][j] + " ");
			}
			System.out.println();
		}

		
		for (int i = 1; i < n+1; i++) {
			boolean flag = true;
			for (int j = 1; j < n+1; j++) {
				if (i != j && floyd[i][j] == INF && floyd[j][i] == INF) {
					flag = false;
					break;
				}
			}
			if (flag)
				answer++;
		}

		System.out.println(answer);
	}

}
