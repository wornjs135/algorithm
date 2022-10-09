package olimpiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828_냉장고 {
	
	static class Temp implements Comparable<Temp>{
		int ltemp;
		int htemp;
		
		public Temp(int ltemp, int htemp) {
			super();
			this.ltemp = ltemp;
			this.htemp = htemp;
		}

		@Override
		public int compareTo(Temp o) {
			return this.htemp != o.htemp ? this.htemp - o.htemp: this.ltemp - o.ltemp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Temp[] temps = new Temp[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			temps[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int count = getRefrigerator(temps, new boolean[N]);
		
		sb.append(count);
		System.out.println(sb);
		in.close();
	}

	
	private static int getRefrigerator(Temp[] temps, boolean[] isChecked) {
		int count = 0;
		Arrays.sort(temps);
		
		for (int i = 0; i < temps.length; i++) {
			if(!isChecked[i]) {
				int j = i+1;
				while (j < temps.length && temps[i].htemp >= temps[j].ltemp) {
					isChecked[j] = true;
					j++;
				}
				count++;
			}
		}
		
		return count;
	}


//	static String str = "4\r\n" + 
//			"-15 5\r\n" + 
//			"-10 36\r\n" + 
//			"10 73\r\n" + 
//			"27 44";
}
