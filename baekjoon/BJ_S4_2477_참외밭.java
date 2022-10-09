package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S4_2477_참외밭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(in.readLine());
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		int twice1 = 0;
		int twice2 = 0;
		int first = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(first == 0) first = dir;
			
			if (map.get(dir) != null) {
				map.get(dir).add(len);
				if (twice1 == 0) {
					twice1 = dir;
				} else {
					twice2 = dir;
				}
				
			} else {
				map.put(dir, new ArrayList<>());
				map.get(dir).add(len);
			}
		}
		
		int bigS = 1;
		int smallS = 1;
		
		int result = 0;
		if(first != twice1 && first != twice2) {
			result = map.get(twice1).get(0) * map.get(twice2).get(1) + map.get(twice1).get(1) * map.get(twice2).get(1) + map.get(twice1).get(0) * map.get(twice2).get(1);
		} else {
			
		}
		
		
		for (int i = 1; i <= 4; i++) {
			if(i != twice1 && i != twice2) {
				bigS *= map.get(i).get(0);
			} else {
				if (first != twice1 && first != twice2) {
					if (i == twice1) {
						smallS *= map.get(i).get(1);
					} else {
						smallS *= map.get(i).get(0);
					}
				} else {
					if(first == twice1 && i == twice1) {
						smallS *= map.get(i).get(0);
					} else if (first == twice2 && i == twice2) {
						smallS *= map.get(i).get(1);
					}
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		in.close();
	}

	static String str = "7\r\n" + 
			"4 50\r\n" + 
			"2 160\r\n" + 
			"3 30\r\n" + 
			"1 60\r\n" + 
			"3 20\r\n" + 
			"1 100";
	
}
