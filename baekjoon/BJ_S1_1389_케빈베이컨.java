package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1389_케빈베이컨 {
	
	static int MAX = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] matrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			matrix[first][second] = 1;
			matrix[second][first] = 1;
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (i != j && matrix[i][j] == 0) {
					matrix[i][j] = MAX;
				}
			}
		}
		
		for (int k = 1; k < matrix.length; k++) {
			for (int i = 1; i < matrix.length; i++) {
				if(i == k) continue;
				for (int j = 1; j < matrix.length; j++) {
					if (i == j || k == j) continue;
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		
		int people = 0;
		int min_sum = Integer.MAX_VALUE;
		
		for (int i = 1; i < matrix.length; i++) {
			int sum = 0;
			for (int j = 1; j < matrix.length; j++) {
				sum += matrix[i][j];
			}
			
			if (min_sum > sum) {
				min_sum = sum;
				people = i;
			}
		}
		
		
		sb.append(people);
		System.out.println(sb);
		
		in.close();
	}

	static String str = "5 5\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"4 5\r\n" + 
			"4 3\r\n" + 
			"3 2";
	
}
