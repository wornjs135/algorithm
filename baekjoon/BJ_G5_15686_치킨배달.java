package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15686_치킨배달 {
	
	static int total_min = Integer.MAX_VALUE;
	
	static class House {
		int r;
		int c;
		public House(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class Chicken {
		int r;
		int c;
		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		List<House> houses = new ArrayList<>();
		List<Chicken> chickens = new ArrayList<>();
		
		
		// 집과 치킨집의 좌표를 각각의 리스트에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					houses.add(new House(i,j));
				} else if (temp == 2) {
					chickens.add(new Chicken(i,j));
				}
			}
		}
		
		// 치킨집을 조합으로 선택
		combination(chickens, houses, 0, 0, M, new Chicken[M]);
		
		sb.append(total_min);
		System.out.println(sb);
		in.close();
	}

	private static void combination(List<Chicken> chickens, List<House> houses, int cnt, int start, int M, Chicken[] choice) {
		// M개 만큼 뽑으면 거리 계산
		if(cnt == M) {
			calcDistance(houses, choice);
			return;
		}
		
		// 조합 돌리기
		for (int i = start; i < chickens.size(); i++) {
			choice[cnt] = chickens.get(i);
			combination(chickens, houses, cnt+1, i+1, M, choice);
		}
	}

	private static void calcDistance(List<House> houses, Chicken[] choice) {
		int sum = 0;
		for (int i = 0, size = houses.size(); i < size; i++) {
			int distance_min = Integer.MAX_VALUE;
			for (int j = 0, size2 = choice.length; j < size2; j++) {
				// 집을 차례대로 돌면서 치킨집들과의 치킨거리 최소값 구하기
				int temp = Math.abs(houses.get(i).r - choice[j].r) + Math.abs(houses.get(i).c - choice[j].c);
				if (distance_min > temp) {
					distance_min = temp;
				}
			}
			// 도시의 치킨 거리에 더해주기
			sum += distance_min;
		}
		// 최소값 넣어주기
		if (total_min > sum)
			total_min = sum;
	}

//	static String str = "5 3\r\n" + 
//			"0 0 1 0 0\r\n" + 
//			"0 0 2 0 1\r\n" + 
//			"0 1 2 0 0\r\n" + 
//			"0 0 1 0 0\r\n" + 
//			"0 0 0 0 2";
	
}
