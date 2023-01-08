package oneDimensionArray;

import java.util.Scanner;

public class OverAverage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int student = sc.nextInt();
			int[] scores = new int[student];

			for (int j = 0; j < student; j++) {
				scores[j] = sc.nextInt();
			}

			int sum = 0;

			for (int s : scores) {
				sum += s;
			}

			double ave = 0.0;
			ave = ((double) sum) / student;
			int cnt = 0;
			for (int s : scores) {
				if (s > ave) {
					cnt++;
				}
			}

			double result = (((double) cnt) / student) * 100;

			System.out.println(String.format("%.3f", result) + "%");

		}

		sc.close();
	}
}
