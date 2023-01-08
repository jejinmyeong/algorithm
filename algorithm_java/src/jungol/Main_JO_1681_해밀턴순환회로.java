package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
	static int N, ans;
	static int [][] matrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		matrix = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j  = 0 ; j < N ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 987654321;
		
		backTracking(0, 0, 0, new boolean [N]);
		
		System.out.println(ans);
	}
	
	static void backTracking(int cnt, int start, int sum, boolean [] visited) {
		if (sum > ans) {
			return;
		}
		
		if (cnt == N-1) {
			if (matrix[start][0] == 0) return;
			sum += matrix[start][0];
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = 1 ; i < N ; i++) {
			if (visited[i] || matrix[start][i] == 0) continue;
			
			visited[i] = true;
			backTracking(cnt+1, i, sum+matrix[start][i], visited);
			visited[i] = false;
		}
	}
}
