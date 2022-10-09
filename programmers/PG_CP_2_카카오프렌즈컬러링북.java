package programmers;

public class PG_CP_2_카카오프렌즈컬러링북 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int numOfArea = 0;
	static int maxSizeOneArea = -99999;
	static int cnt= 1;

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[][] cp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cp[i][j] = picture[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (cp[i][j] != 0) {
					dfs(i, j, m, n, cp);
					if(maxSizeOneArea < cnt) {
						maxSizeOneArea = cnt;
					}
					numOfArea++;
					cnt = 1;
				}
			}
		}
		numberOfArea = numOfArea;
		maxSizeOfOneArea = maxSizeOneArea;

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		if(answer[0] == 0) {
			answer[1] = 0;
		} else {
			answer[1] = maxSizeOfOneArea;
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	private static void dfs(int currR, int currC, int m, int n, int[][] picture) {

		int temp = picture[currR][currC];
		picture[currR][currC] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = currR + dr[i];
			int nc = currC + dc[i];
			if (isValid(nr, nc, m, n) && picture[nr][nc] != 0 && picture[nr][nc] == temp) {
				dfs(nr, nc, m, n, picture);
				cnt++;
			}
		}
	}

	private static boolean isValid(int nr, int nc, int m, int n) {
		return nr >= 0 && nr < m && nc >= 0 && nc < n;
	}

}
