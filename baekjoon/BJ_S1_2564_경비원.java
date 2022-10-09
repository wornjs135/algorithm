package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int[][] point = new int[K][2];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				point[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] myPoint = new int[2];
		st = new StringTokenizer(in.readLine());
		myPoint[0] = Integer.parseInt(st.nextToken());
		myPoint[1] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for (int i = 0; i < K; i++) {
			if(whereDirection(myPoint, point[i][0]) == 1) {
				result += Math.abs(myPoint[1] - point[i][1]);
			} else if (whereDirection(myPoint, point[i][0]) == 2) {
				if (myPoint[0] == 1 || myPoint[0] == 2) {
					if (myPoint[1]+point[i][1] > N) {
						result += (N-myPoint[1]) + (N-point[i][1]);
					} else {
						result += myPoint[1]+point[i][1];
					}
					result += M;
				} else {
					if (myPoint[1]+point[i][1] > M) {
						result += (M-myPoint[1]) + (M-point[i][1]);
					} else {
						result += myPoint[1]+point[i][1];
					}
					result += N;
				}
			} else if (whereDirection(myPoint, point[i][0]) == 3){
				if (myPoint[0] == 1) {
					result += myPoint[1] + point[i][1];
				} else if (myPoint[0] == 2) {
					result += myPoint[1] + (M - point[i][1]);
				} else if (myPoint[0] == 3) {
					result += myPoint[1] + point[i][1];
				} else {
					result += (M-myPoint[1]) + (N-point[i][1]);
				}
			} else {
				if (myPoint[0] == 1) {
					result += (N-myPoint[1]) + point[i][1];
				} else if (myPoint[0] == 2) {
					result += (N-myPoint[1]) + (M - point[i][1]);
				} else if (myPoint[0] == 3) {
					result += (M-myPoint[1]) + point[i][1];
				} else {
					result += myPoint[1] + (N-point[i][1]);
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	// 같은쪽=1, 반대편=2, 왼쪽=3, 오른쪽=4
	private static int whereDirection(int[] myPoint, int i) {
		if (myPoint[0] == 1) {
			if(i == 1) {
				return 1;
			} else if(i == 2) {
				return 2;
			} else if (i == 3){
				return 3;
			} else {
				return 4;
			}
		} else if (myPoint[0] == 2) {
			if(i == 2) {
				return 1;
			} else if(i == 1) {
				return 2;
			} else if (i == 3){
				return 3;
			} else {
				return 4;
			}
		} else if (myPoint[0] == 3) {
			if(i == 3) {
				return 1;
			} else if(i == 4) {
				return 2;
			} else if (i == 1){
				return 3;
			} else {
				return 4;
			}
		} else {
			if(i == 4) {
				return 1;
			} else if(i == 3) {
				return 2;
			} else if (i == 2){
				return 3;
			} else {
				return 4;
			}
		}
	}

//	static String str = "10 5\r\n" + 
//			"3\r\n" + 
//			"1 4\r\n" + 
//			"3 2\r\n" + 
//			"2 8\r\n" + 
//			"2 3";
	
}
