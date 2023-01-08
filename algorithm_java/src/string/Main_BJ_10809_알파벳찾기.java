package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int[] alphabet = new int[26];

		Arrays.fill(alphabet, -1);

		for (int i = 0; i < str.length(); i++) {
			if (alphabet[str.charAt(i) - 'a'] == -1) alphabet[str.charAt(i) - 'a'] = i;
		}
		
		for (int i : alphabet) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}
}
