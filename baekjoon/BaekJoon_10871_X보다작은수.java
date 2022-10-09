package baekjoon;

import java.util.Scanner;

public class BaekJoon_10871_X보다작은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int X = sc.nextInt();

        int[] array = new int[T];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if (array[i] < X)
                System.out.print(array[i] + " ");
        }
    }
}
