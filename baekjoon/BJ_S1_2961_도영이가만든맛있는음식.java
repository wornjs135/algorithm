package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2961_도영이가만든맛있는음식 {
	
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		long[][] flavor = new long[N][2];
		
		for (int i = 0; i < flavor.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			flavor[i][0] = Long.parseLong(st.nextToken());
			flavor[i][1] = Long.parseLong(st.nextToken());
		}
		
		long sour = 1;
		long bitters = 0;
		
		subset(0, sour, bitters, N, flavor);
		
		sb.append(min);
		
		System.out.println(min);
		in.close();
	}

	private static void subset(int cnt, long sour, long bitters, int N, long[][] flavor) {
		if (cnt == N) {
			if (sour != 1 && bitters != 0 ) {
				if (min > Math.abs(sour-bitters)) {
					min = Math.abs(sour-bitters);
				}
			}
			return;
		}
		
		// 선택
		subset(cnt+1, sour * flavor[cnt][0], bitters + flavor[cnt][1], N, flavor);
		
		// 비선택
		subset(cnt+1, sour, bitters, N, flavor);
		
	}

//	static String str = "2\r\n" + 
//			"3 8\r\n" + 
//			"5 8";
}
