package funtion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if (N < 100) {
			System.out.println(N);
			return;
		}
		
		int ans = 0;
		
		for (int i = 100 ; i <= N ; i++) {
			String num = String.valueOf(i);
			int gap = (num.charAt(0) - '0') - (num.charAt(1) - '0');
			for (int j = 1 ; j < num.length()-1 ; j++) {
				if (((num.charAt(j) - '0')-(num.charAt(j+1) - '0')) == gap) ans++;
			}
		}
		
		System.out.println(ans+99);
		
		
	}
}
