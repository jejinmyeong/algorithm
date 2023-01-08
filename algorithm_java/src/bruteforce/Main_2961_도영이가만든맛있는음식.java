package bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	static int[] sour;
	static int[] bitt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			st = new StringTokenizer(br.readLine());
			int sourScore = Integer.parseInt(st.nextToken());
			int bittScore = Integer.parseInt(st.nextToken());
			
			int ans = sourScore > bittScore? sourScore-bittScore: bittScore-sourScore;
			
			System.out.println(ans);
			return;
		}

		sour = new int[N];
		bitt = new int[N];
		
		int amount = 1;
		for(int i = 0; i<N;i++) {
			amount *= 2;
		}
		
		int [] ans = new int[amount-1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitt[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < amount; i++) {
			String binary1 = Integer.toBinaryString(i);
			while(binary1.length() != N) {
				binary1 = "0"+binary1;
			}
			char [] b1 = binary1.toCharArray();
			int sourScore = 1;
			int bittScore = 0;
			for(int s = 0 ; s < b1.length ; s++) {
				if (b1[s] == '1') {
					sourScore *= sour[s];
					bittScore += bitt[s];
				}
			}

			ans[i-1] = sourScore > bittScore? sourScore-bittScore: bittScore-sourScore;	
		}
		Arrays.sort(ans);
		System.out.println(ans[0]);
	}
}
