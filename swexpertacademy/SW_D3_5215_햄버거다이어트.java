package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW_D3_5215_햄버거다이어트 {
	
//	static String st = "1\r\n" + 
//			"5 1000\r\n" + 
//			"100 200\r\n" + 
//			"300 500\r\n" + 
//			"250 300\r\n" + 
//			"500 1000\r\n" + 
//			"400 400";
	
	static int N, L;
	static int maxPoint = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			String s1 = in.readLine();
			N = Integer.parseInt(s1.split(" ")[0]);
			L = Integer.parseInt(s1.split(" ")[1]);
			
			int[] igr = new int[N];
			int[] cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				String s2 = in.readLine();
				igr[i] = Integer.parseInt(s2.split(" ")[0]);
				cal[i] = Integer.parseInt(s2.split(" ")[1]);
			}
			
			burger(igr, cal, 0, 0, 0);
			sb.append(maxPoint).append("\n");
			maxPoint = 0;
		}
		
		System.out.println(sb);
		in.close();
	}

	private static void burger(int[] igr, int[] cal, int count, int pointSum, int calSum) {
		
		if (count == N) {
			if (calSum <= L && maxPoint < pointSum) {
				maxPoint = pointSum;
			}
			return;
		}
		
		// 선택
		burger(igr, cal, count+1, pointSum + igr[count], calSum + cal[count]);
			
		// 비선택
		burger(igr, cal, count+1, pointSum, calSum);
	}

}
