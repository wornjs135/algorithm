package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_17471_게리멘더링 {
	
	static class Town {
		int to;
		Town link;
		int gu;
		
		public Town(int to, Town link) {
			super();
			this.to = to;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Town [to=" + to + ", link=" + link + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Town[] towns = new Town[N+1];
		
		int[] population = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < population.length; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				towns[i] = new Town(to, towns[i]);
			}
		}
		
		
		
		in.close();
	}
	static String str = "6\r\n" + 
			"5 2 3 4 1 2\r\n" + 
			"2 2 4\r\n" + 
			"4 1 3 6 5\r\n" + 
			"2 4 2\r\n" + 
			"2 1 3\r\n" + 
			"1 2\r\n" + 
			"1 2";
}
