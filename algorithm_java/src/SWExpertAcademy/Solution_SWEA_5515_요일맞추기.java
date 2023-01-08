package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5515_요일맞추기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int [] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int init = 3;
		
		for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int m, d;
			m = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			int day = 0; // 2015년 12월 31일로 부터 경과 일 수
			for (int i = 0 ; i < m-1 ; i++) {
				day += days[i];
			}
			day += d;
			
			int ans = (day + init)%7;
			
			sb.append("#" + tc +" "+ans+"\n");
		}
		System.out.println(sb);
		
	}
}
