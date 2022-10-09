package programmers;

import java.util.Arrays;

public class PG_CP_3_GPS {
	
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		int answer = 0;
		
		int[][] adjMatrix = new int[n+1][n+1];
		
		for (int i = 0; i < edge_list.length; i++) {
			adjMatrix[edge_list[i][0]][edge_list[i][1]] = 1;
			adjMatrix[edge_list[i][1]][edge_list[i][0]] = 1;
		}
		
		print(adjMatrix);
		
		for (int i = 0; i < k-1; i++) {
			if(edge_list[gps_log[k]][gps_log[k+1]] == 1) {
				continue;
			} else {
				dfs(adjMatrix, gps_log, k, new boolean[k+1], n);
			}
		}
		
        System.out.println(answer);
	}

	private static void dfs(int[][] adjMatrix, int[] gps_log, int k, boolean[] visited, int n) {
		visited[k] = true;
		for (int i = 0; i < n; i++) {
			
		}
	}

	private static void print(int[][] adjMatrix) {
		for (int i = 1; i < adjMatrix.length; i++) {
			for (int j = 1; j < adjMatrix.length; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
