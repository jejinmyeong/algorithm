package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T;test_case++) {
			int [][] arr = new int[test_case][test_case];
			int n = 1;
			int tc = Integer.parseInt(br.readLine());
			int E = test_case-1, W = 0, N = 0, S = test_case-1;
			while(n <= test_case*test_case) {
				for(int i = W;i <= E;i++) {
					arr[N][i] = n;
					n++;
				}
				N++;
				for(int i = N;i<=S;i++) {
					arr[i][E] = n;
					n++;
				}
				E--;
				for(int i = E;i >= W;i--) {
					arr[S][i] = n;
					n++;
				}
				S--;
				for(int i = S;i>=N;i--) {
					arr[i][W] = n;
					n++;
				}
				W++;
			}
			System.out.println("#"+tc);
			for(int i =0;i<test_case;i++) {
				for(int j = 0;j<test_case;j++) {
					System.out.print(arr[i][j]+" ");		
				}
				System.out.println();
			}
		}
		
	}
}
