package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_16236_아기상어_re {
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int result = 0;
	static int N;
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int moveCnt;
		
		public Point(int r, int c, int moveCnt) {
			super();
			this.r = r;
			this.c = c;
			this.moveCnt = moveCnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.r == o.r ? this.c - o.c : this.r - o.r;
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		
		int shark_r = -1;
		int shark_c = -1;
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark_r = i;
					shark_c = j;
				}
			}
		}
		
		bfs(map, shark_r, shark_c);

		
		in.close();
	}
	private static void bfs(int[][] map, int shark_r, int shark_c) {
		int countEat = 0;
		int sharkLevel = 2;
		boolean[][][] isVisited = new boolean[N][N][N*N];
		int currIsVisitedNum = 0;
		List<Point> canEat = new ArrayList<>();
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(shark_r, shark_c, 0));
		isVisited[shark_r][shark_c][currIsVisitedNum] = true;
		map[shark_r][shark_c] = 0;
		
		while(!q.isEmpty()) {
//			if(!checkEatFlag(map, sharkLevel)) {
//				System.out.println(result);
//				System.exit(0);
//			}
//			q.sort(new Comparator<Point>() {
//
//				@Override
//				public int compare(Point o1, Point o2) {
//					// TODO Auto-generated method stub
//					return o1.r == o2.r ? o1.c - o2.c : o1.r - o2.r;
//				}
//			});
			for (int i = 0, size = q.size(); i < size; i++) {
				Point temp = q.poll();
//				System.out.println(temp.r + " " + temp.c);
				boolean flag = false;
				for (int k = 0; k < 4; k++) {
					int nr = temp.r + dr[k];
					int nc = temp.c + dc[k];
					if(isValid(nr, nc) && !isVisited[nr][nc][currIsVisitedNum]) {
						if (map[nr][nc] == 0 || map[nr][nc] == sharkLevel) {
							q.offer(new Point(nr, nc, temp.moveCnt+1));
							isVisited[nr][nc][currIsVisitedNum] = true;
//							System.out.println("그냥 이동:" + nr + " " + nc + " " + (temp.moveCnt+1));
						} else if (map[nr][nc] < sharkLevel) {
//							System.out.println("먹기 후보:" + nr + " " + nc + " " + (temp.moveCnt+1));
							canEat.add(new Point(nr, nc, (temp.moveCnt+1)));
						}
					}
				}
				
			}
			if(canEat.size() != 0) {
				canEat.sort(new Comparator<Point>() {

					@Override
					public int compare(Point o1, Point o2) {
						// TODO Auto-generated method stub
						return o1.r == o2.r ? o1.c - o2.c : o1.r - o2.r;
					}
				});
				
				Point curr = canEat.get(0);
				result += curr.moveCnt;
//				System.out.println(result + "result");
//				System.out.println(curr.r + " " + curr.c + " " + (curr.moveCnt));
				map[curr.r][curr.c] = 0;
				
				countEat++;
				q.clear();
				q.offer(new Point(curr.r, curr.c, 0));
				canEat.clear();
				currIsVisitedNum+=1;
				isVisited[curr.r][curr.c][currIsVisitedNum] = true;
				if(countEat == sharkLevel) {
					sharkLevel++;
					countEat = 0;
				}
			}
		}
		System.out.println(result);
		System.exit(0);
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	private static boolean checkEatFlag(int[][] map, int sharkLevel) {
		boolean result = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((map[i][j] != 0) && (map[i][j] < sharkLevel)) {
					return true;
				}
			}
		}
		
		return result;
	}
	
	static String str = "3\r\n" + 
			"9 2 2\r\n" + 
			"2 2 3\r\n" + 
			"1 3 1";
}
