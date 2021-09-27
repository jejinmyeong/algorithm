package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1755_숫자놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		String [] nums = new String[N-M+1];
		
		for (int i = M ; i < N+1 ; i++){
			String num = String.valueOf(i);
			char [] arrNum = new char[num.length()]; 
			for (int j = 0 ; j < num.length() ; j++) {
				arrNum[j] = num.charAt(j);
			}
			String temp = "";
			for (int j = 0 ; j < arrNum.length; j++) {
				switch (arrNum[j]) {
				case '1':
					temp += "one ";
					break;
				case '2':
					temp += "two ";
					break;
				case '3':
					temp += "three ";
					break;
				case '4':
					temp += "four ";
					break;
				case '5':
					temp += "five ";
					break;
				case '6':
					temp += "six ";
					break;
				case '7':
					temp += "seven ";
					break;
				case '8':
					temp += "eight ";
					break;
				case '9':
					temp += "nine ";
					break;
				case '0':
					temp += "zero ";
					break;
				}
			}
			nums[i-M] = temp;
		}
		Arrays.sort(nums);
		
		for (int i = 0  ; i < nums.length ; i++) {
			if (i % 10 == 0 && i != 0) {
				sb.append("\n");
			}
			st = new StringTokenizer(nums[i]);
			while(st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "one":
					sb.append(1);
					break;
				case "two":
					sb.append(2);
					break;
				case "three":
					sb.append(3);
					break;
				case "four":
					sb.append(4);
					break;
				case "five":
					sb.append(5);
					break;
				case "six":
					sb.append(6);
					break;
				case "seven":
					sb.append(7);
					break;
				case "eight":
					sb.append(8);
					break;
				case "nine":
					sb.append(9);
					break;
				case "zero":
					sb.append(0);
					break;
				}
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
