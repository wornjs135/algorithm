package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S1_14888_연산자끼워넣기 {

	static int OPER_N;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		OPER_N = N - 1;
		int[] number = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		oper = new int[N - 1];
		st = new StringTokenizer(in.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int product = Integer.parseInt(st.nextToken());
		int division = Integer.parseInt(st.nextToken());

		// + 추가
		for (int i = 0; i < plus; i++) {
			oper[i] = 1;
		}
		
		// - 추가
		int pm = plus + minus;
		for (int i = plus; i < pm; i++) {
			oper[i] = 2;
		}
		
		// * 추가
		int pmp = plus + minus + product;
		for (int i = pm; i < pmp; i++) {
			oper[i] = 3;
		}
		
		// / 추가
		int pmpd = plus + minus + product + division;
		for (int i = pmp; i < pmpd; i++) {
			oper[i] = 4;
		}

		// np
		do {
			Stack<Integer> calc = new Stack<>();
			int j = 0;
			for (int i = 0; i < number.length; i++) {
				if (calc.size() == 0) {
					calc.push(number[i]);
				} else {
					int temp = calc.pop();
					if (oper[j] == 1) {
						calc.add(temp + number[i]);
					} else if (oper[j] == 2) {
						calc.add(temp - number[i]);
					} else if (oper[j] == 3) {
						calc.add(temp * number[i]);
					} else if (oper[j] == 4) {
						calc.add(temp / number[i]);
					}
					j++;
				}
			}
			int result = calc.pop();
			if (result > max)
				max = result;
			if (result < min)
				min = result;
		} while (np());

		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		in.close();
	}

	private static boolean np() {

		// 바꿀 위치 찾기
		int i = OPER_N - 1;
		while (i > 0 && oper[i - 1] >= oper[i])
			i--;

		if (i == 0)
			return false;

		// 교환할 위치에 교환할 값 찾기
		int j = OPER_N - 1;
		while (oper[i - 1] >= oper[j])
			j--;

		// 바꾸기
		swap(i - 1, j);

		// 바꾼 위치 뒤부터 끝까지 오름차순 정렬
		int k = OPER_N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = oper[i];
		oper[i] = oper[j];
		oper[j] = temp;
	}

//	static String str = "2\r\n" + 
//			"5 6\r\n" + 
//			"0 0 1 0";
}
