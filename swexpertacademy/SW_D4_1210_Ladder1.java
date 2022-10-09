package swexpertacademy;

import java.io.*;
import java.util.StringTokenizer;

public class SW_D4_1210_Ladder1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        in = new BufferedReader(new StringReader(st));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int test_case = Integer.parseInt(in.readLine());
            int[][] ladder = new int[100][100];
            int[][] checked = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 도착점 찾기
            int r = 98;
            int c = 0;
            for (int j = 0; j < 100; j++) {
                if (ladder[99][j] == 2) {
                    c = j;
                    break;
                }
            }

            while (r > 0) {
                if (c - 1 >= 0 && ladder[r][c - 1] == 1 && checked[r][c - 1] != 1) {
                    c = c - 1;
                    checked[r][c] = 1;
                    while (ladder[r - 1][c] == 0) {
                        c = c - 1;
                        checked[r][c] = 1;
                    }
                } else if (c + 1 < 100 && ladder[r][c + 1] == 1 && checked[r][c + 1] != 1) {
                    c = c + 1;
                    checked[r][c] = 1;
                    while (ladder[r - 1][c] == 0) {
                        c = c + 1;
                        checked[r][c] = 1;
                    }
                } else if (r - 1 >= 0 && ladder[r - 1][c] == 1) {
                    r = r - 1;
                    checked[r][c] = 1;
                }
            }
            sb.append(c).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
    
}
