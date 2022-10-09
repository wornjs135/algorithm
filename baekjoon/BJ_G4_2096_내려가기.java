package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2096_내려가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		long [][] scoreMax = new long[N][3];
		long [][] scoreMin = new long[N][3];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				scoreMax[i][j] = temp;
				scoreMin[i][j] = temp;
			}
		}
		
		for (int i = 1; i <= N-1; i++) {
			scoreMax[i][0] += Math.max(scoreMax[i-1][0], scoreMax[i-1][1]);
			scoreMax[i][1] += Math.max(Math.max(scoreMax[i-1][0], scoreMax[i-1][1]), scoreMax[i-1][2]);
			scoreMax[i][2] += Math.max(scoreMax[i-1][1], scoreMax[i-1][2]);
		}
		sb.append(Math.max(Math.max(scoreMax[N-1][0], scoreMax[N-1][1]), scoreMax[N-1][2])).append(" ");
		
		for (int i = 1; i <= N-1; i++) {
			scoreMin[i][0] += Math.min(scoreMin[i-1][0], scoreMin[i-1][1]);
			scoreMin[i][1] += Math.min(Math.min(scoreMin[i-1][0], scoreMin[i-1][1]), scoreMin[i-1][2]);
			scoreMin[i][2] += Math.min(scoreMin[i-1][1], scoreMin[i-1][2]);
		}
		sb.append(Math.min(Math.min(scoreMin[N-1][0], scoreMin[N-1][1]), scoreMin[N-1][2]));
		
		System.out.println(sb);
		in.close();
	}

	static String str = "3\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1";
	
}
