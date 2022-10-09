package olimpiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for (int i = 1; i < N+1; i++) {
			st= new StringTokenizer(in.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// Prim 응용해서 해볼랫는데 안됨.
		int[] minEdge = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		int result = 0;
		minEdge[1] = 0;
		
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for (int j = 1; j < N+1; j++) {
				if (!visited[i] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			visited[minVertex] = true;
			result += min;
			
		}
		
		in.close();
	}

	static String str = "5\r\n" + 
			"0 14 4 10 20 \r\n" + 
			"14 0 7 8 7 \r\n" + 
			"4 5 0 7 16 \r\n" + 
			"11 7 9 0 2 \r\n" + 
			"18 7 17 4 0";
	
}
