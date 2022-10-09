package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1759_암호만들기 {
	
	static char[] result;
	static StringBuilder sb;
	static List<String> list = new ArrayList<>();
	
	public static boolean isConsonant(char ch) {
		if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
			return true;
		return false;
	}
	
	public static void findPassword(int cnt, int start, char[] c, int L, int consonantCnt, int vowelCnt) {
		if (cnt == L) {
			if (consonantCnt >= 2 && vowelCnt >= 1) {
				list.add(String.valueOf(result));
			}
			return;
		}
		
		for (int i = start; i < c.length; i++) {
			result[cnt] = c[i];
			boolean isConsonant = isConsonant(c[i]);
			findPassword(cnt+1, i+1, c, L, isConsonant?consonantCnt+1:consonantCnt, isConsonant?vowelCnt:vowelCnt+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		char[] c = new char[C];
		result = new char[L];
		for (int i = 0; i < C; i++) {
			c[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(c);
		
		findPassword(0, 0, c, L, 0, 0);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}
	
	static String str = "4 6\r\n" + 
			"a t c i s w";

}
