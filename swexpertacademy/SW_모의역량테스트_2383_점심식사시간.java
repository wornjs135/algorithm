package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_모의역량테스트_2383_점심식사시간 {
	
	static class Person {
		int r;
		int c;
		int moveCnt;
		
		public Person(int r, int c, int moveCnt) {
			super();
			this.r = r;
			this.c = c;
			this.moveCnt = moveCnt;
		}
	}
	
	static class Stair {
		int r;
		int c;
		int personCnt;
		public Stair(int r, int c, int personCnt) {
			super();
			this.r = r;
			this.c = c;
			this.personCnt = personCnt;
		}
		
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			PriorityQueue<Person> pq = new PriorityQueue<>();
			List<Stair> stairs = new ArrayList<>();
			
			int person = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						pq.add(new Person(i, j, 0));
						person++;
					} else if (map[i][j] > 1) {
						stairs.add(new Stair(i, j, 0));
					}
				}
			}
			
			bfs(pq, stairs, person);
			
		}
	}

	private static void bfs(PriorityQueue<Person> pq, List<Stair> stairs, int person) {
		int people = person;
		while(people == 0 || !pq.isEmpty()) {
			Person p = pq.poll();
			
		}
	}

	static String str = "2\r\n" + 
			"5\r\n" + 
			"0 1 1 0 0\r\n" + 
			"0 0 1 0 3\r\n" + 
			"0 1 0 1 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 5 0 0\r\n" + 
			"5\r\n" + 
			"0 0 1 1 0\r\n" + 
			"0 0 1 0 2\r\n" + 
			"0 0 0 1 0\r\n" + 
			"0 1 0 0 0\r\n" + 
			"1 0 5 0 0";
}
