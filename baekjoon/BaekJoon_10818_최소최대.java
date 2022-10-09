package baekjoon;

import java.util.Scanner;

public class BaekJoon_10818_최소최대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;

        int N = sc.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if (array[i] > MAX)
                MAX = array[i];
            if (array[i] < MIN)
                MIN = array[i];

        }

        System.out.println(MIN + " " + MAX);
    }
}
