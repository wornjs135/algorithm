package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_D3_1228_암호문1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(st));
		StringBuilder sb = new StringBuilder();
		
		int T = 10; 
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st1 = new StringTokenizer(in.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			while(st1.hasMoreTokens()) {
				list.add(Integer.parseInt(st1.nextToken()));
			}
			
			int C = Integer.parseInt(in.readLine());
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			while (st2.hasMoreTokens()) {
				if (st2.nextToken().equals("I")) {
					int x = Integer.parseInt(st2.nextToken());
					int count = Integer.parseInt(st2.nextToken());
					for (int i = 1; i <= count; i++) {
						list.add(x, Integer.parseInt(st2.nextToken()));
						x++;
					}
				}
			}
			
			// 결과 추가하기
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		in.close();
	}

	
//	static String st = "11\r\n" + 
//			"449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205\r\n" + 
//			"7\r\n" + 
//			"I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976\r\n" + 
//			"19\r\n" + 
//			"566753 244528 233616 328235 268163 292641 646305 944392 643695 385788 444752 939244 637877 325283 779273 712343 953523 846222 204307\r\n" + 
//			"5\r\n" + 
//			"I 0 4 600576 565945 486128 594841 I 0 1 150706 I 8 8 556294 697547 932203 845517 116062 300371 621038 358830 I 10 8 747039 701738 805438 502654 476665 919177 367272 859931 I 15 3 844423 973297 658751";
}
