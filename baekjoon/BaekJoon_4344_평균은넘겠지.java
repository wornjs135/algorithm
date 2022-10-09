package baekjoon;

import java.util.Scanner;

public class BaekJoon_4344_평균은넘겠지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] score = new int[N];
            int sum = 0;
            double avg = 0;
            int count = 0;
            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextInt();
                sum += score[j];
            }
            avg = (double)sum / score.length;
            for (int j = 0; j < score.length; j++) {
                if (score[j] > avg) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", ((double)count/N) * 100);
        }
    }
}
