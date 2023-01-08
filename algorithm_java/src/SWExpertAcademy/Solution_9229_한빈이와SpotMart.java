package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int []W = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;

			for(int i = 0;i<N;i++) {
				for (int j = i+1;j<N;j++) {
					int sum = W[i]+W[j];
					if(sum <= M && ans<sum)
						ans = sum;
				}
			}
			if (ans == 0) ans = -1;
			System.out.println("#"+tc+" "+ans);
		}
	}
}
