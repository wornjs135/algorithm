package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G4_5427_불 {

    static class Point {
        int r;
        int c;
        int count;

        public Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new StringReader(str));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(in.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            char[][] map = new char[R][C];
            Queue<Point> q = new LinkedList<>();

            int startR = 0;
            int startC = 0;
            for (int j = 0; j < R; j++) {
//                st = new StringTokenizer(in.readLine());
                String s = in.readLine();
                for (int k = 0; k < C; k++) {
//                    map[j][k] = st.nextToken().charAt(0);
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '@') {
                        startR = j;
                        startC = k;
                    } else if (map[j][k] == '*') {
                        q.add(new Point(j, k));
                    }
                }
            }

            int bfs = bfs(map, startR, startC, R, C, q);
            if (bfs == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(bfs).append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        in.close();
    }

    private static int bfs(char[][] map, int startR, int startC, int R, int C, Queue<Point> q) {
        Queue<Point> pq = new LinkedList<>();
        pq.add(new Point(startR, startC, 0));
        boolean[][] isVisited = new boolean[R][C];
        isVisited[startR][startC] = true;

        while (!pq.isEmpty()) {
            // 불 옮기기
            for (int i = 0, size = q.size(); i < size; i++) {
                Point currFire = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = currFire.r + dr[j];
                    int nc = currFire.c + dc[j];
                    if (isValid(nr, nc, R, C) && map[nr][nc] != '#' && map[nr][nc] != '*') {
                        q.add(new Point(nr, nc));
                        map[nr][nc] = '*';
                    }
                }
            }
//            }
            // 사람 옮기기
            for (int i = 0, size = pq.size(); i < size; i++) {
                Point temp = pq.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = temp.r + dr[k];
                    int nc = temp.c + dc[k];

                    if (!isValid(nr, nc, R, C)) {
                        return temp.count + 1;
                    }

                    if (map[nr][nc] == '.' && !isVisited[nr][nc]) {
                        pq.add(new Point(nr, nc, temp.count + 1));
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int nr, int nc, int R, int C) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }

    static String str = "1\n" + "7 6\n" +
            "###.###\n" +
            "#*#.#*#\n" +
            "#.....#\n" +
            "#.....#\n" +
            "#..@..#\n" +
            "#######";
}
