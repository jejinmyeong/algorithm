package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_SWEA_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			int K = Integer.parseInt(br.readLine());
			
			Deque<Integer> [] mag = new ArrayDeque[4];
			
			for (int i = 0 ; i < 4 ; i++) {
				mag[i] = new ArrayDeque<>();
				st = new StringTokenizer(br.readLine());
				for (int j = 0 ; j < 8 ; j++) {
					mag[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			int [][] roMag = new int [K][2];
			
			for (int k = 0 ; k < K ; k++) {
				st = new StringTokenizer(br.readLine());
				roMag[k][0] = Integer.parseInt(st.nextToken());
				roMag[k][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int k = 0 ; k < K ; k++) {
				int idx = roMag[k][0];	// 자석의 인덱스
				int d = roMag[k][1];	// 방향
				
				// 시계 방향 회전 2, 6번 인덱스와 맞닿은 부분이 다른 극인지 확인해서 다른극이면 반대로 회전
				if (d == 1) {
					
				}
				// 반시계 방향 회전
				else {
					
				}
			}
		}
	}
}
