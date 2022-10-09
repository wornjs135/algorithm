package programmers;

public class PG_CP_2_124나라의숫자 {

	public static void main(String[] args) {
		int n = 28;
		String answer = "";

		StringBuilder sb = new StringBuilder();

		int q = 0;
		int r = 0;

		while (n >= 3) {
			r = n % 3;
			if (r == 0) {
				sb.insert(0, 4);
				n = (n / 3) - 1;
			} else {
				sb.insert(0, r);
				n /= 3;
			}
		}
		if(!String.valueOf(n).equals("0")) {
			sb.insert(0, n);
		}
		

		answer = sb.toString();
		System.out.println(answer);
	}

}
