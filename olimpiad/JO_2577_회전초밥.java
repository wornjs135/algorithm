package olimpiad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2577_회전초밥 {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] susi = new int[N];
		boolean[] visited = new boolean[d + 1];
		for (int i = 0; i < N; i++) {
			susi[i] = Integer.parseInt(in.readLine());
		}

		List<Integer> eatList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			eatList = new ArrayList<>();
			eatList.add(c);
			visited[c] = true;
			for (int j = 0; j < k; j++) {
				if (i + j >= N) {
					if (!visited[susi[(i + j) % N]]) {
						eatList.add(susi[(i + j) % N]);
						visited[susi[(i + j) % N]] = true;
					}
				} else {
					if(!visited[susi[i + j]]) {
						eatList.add(susi[i + j]);
						visited[susi[i + j]] = true;
					}
				}
			}

			if (max < eatList.size()) {
				max = eatList.size();
			}
		}

		sb.append(max);
		System.out.println(sb);
		in.close();
	}
	
	static String str = "8 50 4 7\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30";

}
