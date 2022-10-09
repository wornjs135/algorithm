package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SW_D3_6808_규영인영카드게임 {
	
	static int win;
	static int lose;
	
	private static void permutation(int cnt, List<Integer> gyuyoung,  List<Integer> inyoung,  boolean[] isChecked, int[] permu) {
		if (cnt == 9) {
			// 여기서 게임 돌리기
			gameStart(gyuyoung, permu);
			return;
		}
		
		for (int i = 0; i < permu.length; i++) {
			if(!isChecked[i]) {
				permu[cnt] = inyoung.get(i);
				isChecked[i] = true;
				permutation(cnt+1, gyuyoung, inyoung, isChecked, permu);
				isChecked[i] = false;
			}
		}
	}
	
	private static void gameStart(List<Integer> gyuyoung, int[] permu) {
		int gyuyoungScore = 0;
		int inyoungScore = 0;
		
		for (int i = 0; i < 9; i++) {
			if (gyuyoung.get(i) > permu[i]) {
				gyuyoungScore += gyuyoung.get(i) + permu[i];
			}  else {
				inyoungScore += gyuyoung.get(i) + permu[i];
			}
		}
		
		if (gyuyoungScore > inyoungScore) {
			win++;
		} else if(gyuyoungScore < inyoungScore) {
			lose++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			List<Integer> gyuyoung = new ArrayList<>();
			List<Integer> inyoung = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 9; i++) {
				gyuyoung.add(Integer.parseInt(st.nextToken()));
			}
			
			// 인영의 카드
			for (int i = 1; i <= 18; i++) {
				if(gyuyoung.contains(i)) continue;
				inyoung.add(i);
			}
			
			// 인영 카드낼 수 있는 경우 체크 + 게임 시작
			permutation(0, gyuyoung, inyoung, new boolean[9], new int[9]);
			
			sb.append(win).append(" ").append(lose).append("\n");
			win = 0; lose = 0;
		}
		System.out.println(sb);
		in.close();
	}
	
//	static String str = 
//			"4\r\n" + 
//			"1 3 5 7 9 11 13 15 17\r\n" + 
//			"18 16 14 12 10 8 6 4 2\r\n" + 
//			"13 17 9 5 18 7 11 1 15\r\n" + 
//			"1 6 7 9 12 13 15 17 18";
}
