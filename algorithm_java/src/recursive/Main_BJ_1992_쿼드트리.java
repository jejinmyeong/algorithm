package recursive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1992_쿼드트리 {
	static int [][] picture;
	static int [][] divisions = {{0, 0},{1, 0},{0, 1},{1, 1}};
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		picture = new int [N][N];
		int sum = 0;
		
		for(int i = 0 ; i < N ; i++) {
			char [] st = br.readLine().toCharArray();
			for(int j = 0 ; j < N ; j++) {
				picture[i][j] = st[j]-'0';
				sum += picture[i][j];
			}
		}
		
		if (N==1 || sum == N*N || sum==0) {
			if(picture[0][0]==1) System.out.println(1);
			else System.out.println(0);
			return;
		}
		
		division(N, 0 ,0);
		System.out.println(sb);
				
	}
	static void division(int n, int x, int y) {
		if(n==1) return;
				
		n /= 2;
		sb.append("(");
		for(int d = 0; d< 4; d++) {
			int sum = 0;
			int startX = x + n*divisions[d][1], startY = y + n*divisions[d][0];
			for(int i = x + n*divisions[d][1] ; i < x+n*(2-divisions[3-d][1]) ; i++) {
				for(int j = y + n*divisions[d][0] ; j < y+n*(2-divisions[3-d][0]) ; j++) {
					sum+=picture[i][j];
				}
			}
			if (sum == n*n || sum == 0) sb.append(sum/(n*n));
			else division(n, startX, startY);
		}
		sb.append(")");
	}
	
}
