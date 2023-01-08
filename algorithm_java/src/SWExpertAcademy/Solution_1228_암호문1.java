package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer st2;

		List<String> code;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			code = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				code.add(st.nextToken());
			}

			int C = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "I");
			for (int i = 0; i < C; i++) {
				st2 = new StringTokenizer(st.nextToken());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				for(int j = 0; j< y;j++) {
					code.add(x+j, st2.nextToken());
				}				
			}
			System.out.print("#"+tc+" ");
			for(int i = 0 ;i<10;i++) {
				System.out.print(code.get(i)+" ");
			}
			System.out.println();
		}
	}
}
