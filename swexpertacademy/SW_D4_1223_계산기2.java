package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_D4_1223_계산기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			
			String[] st = in.readLine().split("");
			
			Stack<Integer> number = new Stack<>();
			Stack<Character> oper = new Stack<>();
			
			for (int i = 0; i < st.length; i++) {
				if (st[i].equals("+")) {
					oper.push(st[i].charAt(0));
				} else if (st[i].equals("*")) {
					number.push(number.pop() * Integer.parseInt(st[++i]));
				} else {
					number.push(Integer.parseInt(st[i]));
				}
			}
			
			while (!oper.isEmpty()) {
				int a = number.pop();
				int b = number.pop();
				oper.pop();
				number.push(a+b);
			}
			
			sb.append(number.pop()).append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}
	
//	static String str = "101\r\n" + 
//			"9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3";

}
