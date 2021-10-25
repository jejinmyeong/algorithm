package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solutin_SWEA_4311_오래된스마트폰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N, O, M;
			
			N = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 터치 가능한 숫자 배열
			int [] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < N ; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			// 터치가능한 연산자 1: +  2: -  3: *  4: /
			boolean [] oper = new boolean[5];
			
			for (int i = 0 ; i < O ; i++) {
				oper[Integer.parseInt(st.nextToken())] = true;
			}
			
			
			
		}
	}
}
