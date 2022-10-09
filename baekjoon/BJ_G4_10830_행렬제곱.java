package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_10830_행렬제곱 {
	
	static int N;
	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N][N];
		long B = Long.parseLong(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] result = pow(a, B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}
	
	private static int[][] pow(int[][] a, long exp) {
		if(exp == 1) {
			return a;
		}
		
		int[][] ret = pow(a, exp/2);
		
		ret = multiple(ret, ret);
		
		if(exp % 2 == 1) {
			ret = multiple(ret, a);
		}
		
		return ret;
	}

	private static int[][] multiple(int[][] m1, int[][] m2) {
		int[][] newM = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					newM[i][j] += m1[i][k] * m2[k][j];
					newM[i][j] %= 1000;
				}
			}
		}
		
		return newM;
	}

	static String str = "5 10\r\n" + 
			"1 0 0 0 1\r\n" + 
			"1 0 0 0 1\r\n" + 
			"1 0 0 0 1\r\n" + 
			"1 0 0 0 1\r\n" + 
			"1 0 0 0 1";
}
