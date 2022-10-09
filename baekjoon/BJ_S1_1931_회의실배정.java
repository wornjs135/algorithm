package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_1931_회의실배정 {
	
	static class Conference implements Comparable<Conference>{
		int start;
		int finish;
		
		public Conference(int start, int finish) {
			super();
			this.start = start;
			this.finish = finish;
		}

		@Override
		public int compareTo(Conference o) {
			if(this.finish != o.finish) {
				return this.finish - o.finish;
			} else {
				return this.start - o.start;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Conference[] conf = new Conference[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			conf[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(conf);
		
		List<Conference> list = new ArrayList<>();
		
		list.add(conf[0]);
		
		for (int i = 1, size = conf.length; i < size; i++) {
			if (list.get(list.size()-1).finish <= conf[i].start) {
				list.add(conf[i]);
			}
		}
		
		sb.append(list.size());
		
		System.out.println(sb);
		in.close();
	}
	
	static String str = "11\r\n" + 
			"1 4\r\n" + 
			"3 5\r\n" + 
			"0 6\r\n" + 
			"5 7\r\n" + 
			"3 8\r\n" + 
			"5 9\r\n" + 
			"6 10\r\n" + 
			"8 11\r\n" + 
			"8 12\r\n" + 
			"2 13\r\n" + 
			"12 14";

}
