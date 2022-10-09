package programmers;

public class PG_CP_2_멀쩡한사각형 {

	public static void main(String[] args) {
		long answer = 1;
		int w = 8;
		int h = 12;
		
		StringBuilder sb = new StringBuilder();
		
//		double a = (double)h / w;
		long square = 0;
		
		for (int i = 1; i < w; i++) {
			square += Math.floor((double)h * i / w); // 연산 순서 주의
		}
		
		answer = square * 2;
		
		sb.append(answer);
		System.out.println(sb);
	}

}
