package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1107_리모컨 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));

		String NString = in.readLine();
		int M = Integer.parseInt(in.readLine());
		List<Integer> wrongKeyPad = new ArrayList<>();

		int length = NString.length();
		int N = Integer.parseInt(NString);
		int result = Math.abs(100 - N);

		if (N == 100) {
			System.out.println(0);
			System.exit(0);
		}

		if (M == 0) {
			System.out.println(Math.min(length, result));
			System.exit(0);
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			wrongKeyPad.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i <= 999999; i++) {
			String iString = String.valueOf(i);
			boolean check = true;
			for (int j = 0; j < iString.length(); j++) {
				if(wrongKeyPad.contains(iString.charAt(j) - '0')) {
					check = false;
					break;
				}
			}
			
			if(check) {
				int cnt = iString.length() + Math.abs(i - N);
				result = Math.min(result, cnt);
			}
			
		}
		
		System.out.println(result);
		in.close();
	}

	static String str = "1\r\n" + 
			"9\r\n" + 
			"1 2 3 4 5 6 7 8 9";

}
