package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_20055_컨베이어벨트위의로봇 {
	
	static int N, K;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] up = new int[N];
		int[] down = new int[N];
		boolean[] robot = new boolean[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			up[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N-1; i >= 0; i--) {
			down[i] = Integer.parseInt(st.nextToken());
		}
		
//		print(up, down, robot);
		while(true) {
			cnt++;
			
			rotate(up, down, robot);
			
//			print(up, down, robot);
			
			moveRobot(up, robot);
			
//			print(up, down, robot);
			
			putUp(up, robot);
			
//			print(up, down, robot);
			
			
			if(!check(up, down)) {
				break;
			}
			
		}
		
		sb.append(cnt);
		System.out.println(sb);
		in.close();
	}
	
	static void print(int[] up, int[] down, boolean[] robot) {
		for (int i = 0; i < N; i++) {
			System.out.print(up[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(down[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(robot[i] ? "O" :"X");
		}
		System.out.println();
	}
	
	private static boolean check(int[] up, int[] down) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(up[i] == 0) cnt++;
			if(down[i] == 0) cnt++;
		}
		
		if(cnt >= K) 
			return false;
		
		return true;
	}

	private static void putUp(int[] up, boolean[] robot) {
		if(up[0] > 0) {
			up[0]--;
			robot[0] = true;
		}
	}

	private static void moveRobot(int[] up, boolean[] robot) {
		for (int i = N-2; i >= 0; i--) {
			if(up[i+1] > 0 && robot[i] && !robot[i+1]) {
				robot[i+1] = true;
				robot[i] = false;
				up[i+1]--;
			}
		}
		robot[N-1] = false;
	}

	private static void rotate(int[] up, int[] down, boolean[] robot) {
		int firstTemp = up[N-1];
		int secondTemp = down[0];
		
		for (int i = N-1; i >= 1; i--) {
			up[i] = up[i-1];
		}
		up[0] = secondTemp;
		
		for (int i = 0; i < N-1; i++) {
			down[i] = down[i+1];
		}
		down[N-1] = firstTemp;
		
		for (int i = N-1; i >= 1; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
		robot[N-1] = false;
	}

	static String str = "5 8\r\n" + 
			"100 99 60 80 30 20 10 89 99 100";
}
