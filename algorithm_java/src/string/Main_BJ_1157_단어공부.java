package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		str = str.toUpperCase();
		
		int [] cnt = new int [26];
		
		for(int i = 0 ; i < str.length() ;i++) {
			cnt[str.charAt(i) - 'A']++;
		}
		
		int max = 0;
		for (int i = 0 ; i < 26 ; i++) {
			if (cnt[i]>max) max = cnt[i];
		}
		boolean dup = false;
		char ans = 0;
		for (int i = 0 ; i < 26 ; i++) {
			if (dup && cnt[i]==max) {
				System.out.println('?');
				return;
			}
			else if (cnt[i] == max) { 
				dup = true;
				ans = (char)(i+'A');
			}
		}
		
		System.out.println(ans);
	}
}
