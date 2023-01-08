package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_SWEA_양팔저울 {
	static int N;
	static int [] weights, res;
	static boolean [] selected;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			selected = new boolean[N];
			res = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<N;i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			perm(0);
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
	
	static void perm(int cnt) {
		if (cnt == N) {
			//System.out.println(Arrays.toString(res));
			subSet(0,0,0);
			return;
		}
		for(int i = 0 ; i < N ; i++){
			if(selected[i]) continue;
			selected[i] = true;
			res[cnt] = weights[i];
			perm(cnt+1);
			selected[i] = false;
		}
		
	}
	
	static void subSet(int idx, int sumR, int sumL) {
		if (idx == N) {
			ans++;
			return;
		}
		
		subSet(idx+1, sumR, sumL+res[idx]);
		// 오른쪽에 올리는 경우
		if(sumR+res[idx] <= sumL) subSet(idx+1, sumR+res[idx], sumL);
		
		
	}
}
