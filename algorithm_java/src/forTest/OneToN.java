package forTest;

import java.util.*;

public class OneToN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int answer = 0;
		for (int i = 1; i < n + 1; i++) {
			answer += i;
		}

		System.out.println(answer);
		
		//System.out.println((n*(n+1))/2);
	}
}
