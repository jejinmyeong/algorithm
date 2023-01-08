package implementation;

import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sNum = sc.nextInt();
		int[] switchs = new int[sNum + 1];
		for (int i = 1; i < switchs.length; i++) {
			switchs[i] = sc.nextInt();
		}

		int n = sc.nextInt();
		int[][] students = new int[n][2];

		for (int i = 0; i < n; i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (students[i][0] == 1) {
				int now = students[i][1];
				while (now <= sNum) {
					switchs[now] = (switchs[now] + 1) % 2;
					now += students[i][1];
				}
			} else if (students[i][0] == 2) {
				int end;
				if ((switchs.length-1) - students[i][1] >= students[i][1]) {
					end = students[i][1];
				} else {
					end = switchs.length - students[i][1];
				}
				switchs[students[i][1]] = (switchs[students[i][1]] + 1) % 2;
				for (int j = 1; j < end; j++) {
					if (switchs[students[i][1] - j] == switchs[students[i][1] + j]) {
						switchs[students[i][1] - j] = (switchs[students[i][1] - j] + 1) % 2;
						switchs[students[i][1] + j] = (switchs[students[i][1] + j] + 1) % 2;
					} else
						break;
				}
			}

		}

		for (int i = 1; i < switchs.length; i++) {
			System.out.print(switchs[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}
}


