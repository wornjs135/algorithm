package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_모의역량테스트_2112_보호필름 {
	
	static int D;
	static int W;
	static int K;
	static int min = 0;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(check(film)) {
				sb.append(0).append("\n");
				continue;
			} else {
				int i = 1;
				int[] arr = new int[W];
				for (int j = 0; j < i; j++) {
					arr[j] = j;
				}
				 do{
					comb(arr, new int[i], 0, 0, i, film);
					i++;
				}while(!flag);
			}
			
			sb.append(min).append("\n");
			min = 0;
			flag = false;
		}
		
		System.out.println(sb);
		in.close();
	}
	
	
	static boolean comb(int[] arr, int[] selected, int start, int cnt, int injectionCnt, int[][] film) {
		if(cnt == injectionCnt) {
			boolean result = subset(selected, film, 0, new int[injectionCnt]);
			return result;
		}

		for (int i = start; i < arr.length; i++) {
			selected[cnt] = arr[i];
			comb(arr, selected, i+1, cnt+1, injectionCnt, film);
		}
		
		return false;
	}
	
	
	private static boolean subset(int[] selected, int[][] film, int cnt, int[] drug) {
		if(cnt == selected.length) {
			boolean result = inject(drug, film, selected);
			return result;
		}
		
		drug[cnt] = 0;
		subset(selected, film, cnt+1, drug);
		drug[cnt] = 1;
		subset(selected, film, cnt+1, drug);
		
		return false;
	}


	private static boolean inject(int[] drug, int[][] film, int[] selected) {
		int[][] newFilm = new int[D][W];
		copyArray(film, newFilm);
		for (int i = 0; i < selected.length; i++) {
			int r = selected[i];
			for (int c = 0; c < W; c++) {
				newFilm[r][c] = drug[i];
			}
		}
		
		return check(newFilm);
	}

	private static void copyArray(int[][] film, int[][] newFilm) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				newFilm[i][j] = film[i][j];
			}
		}
	}


	private static boolean check(int[][] film) {
		boolean[] checked = new boolean[W];
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			for (int r = 0; r < D; r++) {
				if(r+1 < D && film[r][c] == film[r+1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(cnt == K) {
					checked[c] = true;
				}
			}
		}
		
		for (int i = 0; i < W; i++) {
			if(!checked[i]) return false;
		}
		
		System.out.println("dddd");
		min++;
		flag = true;
		return true;
	}
	static String str = "10\r\n" + 
			"6 8 3\r\n" + 
			"0 0 1 0 1 0 0 1\r\n" + 
			"0 1 0 0 0 1 1 1\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"1 1 1 1 0 0 0 1\r\n" + 
			"0 1 1 0 1 0 0 1\r\n" + 
			"1 0 1 0 1 1 0 1\r\n" + 
			"6 8 3\r\n" + 
			"1 1 1 1 0 0 1 0\r\n" + 
			"0 0 1 1 0 1 0 1\r\n" + 
			"1 1 1 1 0 0 1 0\r\n" + 
			"1 1 1 0 0 1 1 0\r\n" + 
			"1 1 0 1 1 1 1 0\r\n" + 
			"1 1 1 0 0 1 1 0\r\n" + 
			"6 8 4\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"1 0 1 0 0 1 1 1\r\n" + 
			"0 1 0 0 1 1 0 0\r\n" + 
			"1 0 1 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 0 0 0 1 1 1 1\r\n" + 
			"6 4 4\r\n" + 
			"1 1 0 0\r\n" + 
			"0 1 0 1\r\n" + 
			"0 0 0 1\r\n" + 
			"1 1 1 1\r\n" + 
			"1 1 0 1\r\n" + 
			"1 0 1 0\r\n" + 
			"6 10 3\r\n" + 
			"0 1 0 0 0 1 0 0 1 1\r\n" + 
			"0 1 1 0 0 1 0 0 1 0\r\n" + 
			"0 1 0 0 1 0 1 1 1 1\r\n" + 
			"0 0 0 0 0 1 1 1 1 0\r\n" + 
			"0 1 0 0 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 1 1 0 0 1 1\r\n" + 
			"6 6 5\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"6 6 4\r\n" + 
			"1 1 1 1 1 1\r\n" + 
			"0 0 0 0 0 1\r\n" + 
			"0 1 1 1 0 1\r\n" + 
			"0 1 0 1 0 1\r\n" + 
			"0 1 0 0 0 1\r\n" + 
			"0 1 1 1 1 1\r\n" + 
			"8 15 3\r\n" + 
			"0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\r\n" + 
			"1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\r\n" + 
			"1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\r\n" + 
			"1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\r\n" + 
			"0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\r\n" + 
			"0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\r\n" + 
			"10 20 4\r\n" + 
			"1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\r\n" + 
			"1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\r\n" + 
			"1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\r\n" + 
			"0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\r\n" + 
			"0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\r\n" + 
			"1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\r\n" + 
			"1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\r\n" + 
			"0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\r\n" + 
			"0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\r\n" + 
			"13 20 5\r\n" + 
			"1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\r\n" + 
			"1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\r\n" + 
			"1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\r\n" + 
			"0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\r\n" + 
			"0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\r\n" + 
			"0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\r\n" + 
			"1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\r\n" + 
			"0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\r\n" + 
			"0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\r\n" + 
			"0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\r\n" + 
			"0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\r\n" + 
			"0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0\r\n";
}
