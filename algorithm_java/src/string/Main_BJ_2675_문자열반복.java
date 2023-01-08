package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2675_문자열반복 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			for (int j = 0 ; j < S.length() ; j++) {
				for (int k = 0 ; k < r ; k++) {
					sb.append(S.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
