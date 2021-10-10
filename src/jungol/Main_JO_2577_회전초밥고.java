package jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, d, k, c;
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int [] sushi = new int [N+k];
		int [] cnt = new int [d+1];
		
		for (int i = 0 ; i < N ; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		System.arraycopy(sushi, 0, sushi, N, k-1);
		
		int count = 0;
		int max = 0;
		for (int i = 0 ; i < k ; i++) {
			if (cnt[sushi[i]]++ == 0 ) {
				count++;
			}
		}
		
		if (cnt[c] == 0)
			max = count+1;
		else
			max = count;
		
		
		for (int i = 1 ; i < N ; i++) {
			if (cnt[sushi[i + k -1]]++ == 0) {
				count++;
			}
			
			if (--cnt[sushi[i - 1]] < 1)
				count--;
			
			int temp = count;
			
			if (cnt[c] == 0)
				temp++;
			
			if (temp > max)
				max = temp;
		}
		
		System.out.println(max);
	}
}
