package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static LinkedList<Integer> dufability;
	static LinkedList<Boolean> robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dufability = new LinkedList<>();
		robot = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i< 2*N ;i++) {
			dufability.add(Integer.parseInt(st.nextToken()));
			if(i<N) robot.add(false);
		}
	}
	static void move() {
		
	}
	static void rotate() {
		dufability.offerFirst(dufability.pollLast());
		robot.offerFirst(false);
	}
}
