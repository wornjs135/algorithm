package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_1541_잃어버린괄호 {
	
	static int min_sum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), "+:-");
		List<Integer> numbers = new ArrayList<>();
		while (st.hasMoreTokens()) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		subset(numbers, 0, new boolean[numbers.size()]);
		
		sb.append(min_sum);
		System.out.println();
		in.close();
	}
	
	private static void subset(List<Integer> numbers, int cnt, boolean[] isSelected) {
		
		if(cnt == numbers.size()) {
			int sum = 0;
			sum += numbers.get(0);
			
			for (int i = 0; i < numbers.size()-1; i++) {
				if(isSelected[i]) {
					sum += numbers.get(i+1);
				} else {
					sum -= numbers.get(i+1);
				}
			}
			
			if(min_sum > sum) {
				min_sum = sum;
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		subset(numbers, cnt+1, isSelected);
		isSelected[cnt] = false;
		subset(numbers, cnt+1, isSelected);
	}

	static String str = "10+20+30+40";

}
