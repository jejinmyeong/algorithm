package dailyExercise;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		
		GameTest gt = new GameTest();
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");

		Scanner sc = new Scanner(System.in);

		System.out.print("번호를 입력하세요.");
		int choice = sc.nextInt();

		int result = 0;

		if (choice == 1) {
			for (int i = 0; i < 5; i++) {
				System.out.print("가위바위보 중 하나 입력:");
				String input = sc.next();
				int rand = (int) (Math.random() * 3) + 1;
				
				result += gt.RockScissorsPaper(rand, input);

			}
			
			if (result>=3) System.out.println("### 사용자 승!!!");
			else System.out.println("### 컴퓨터 승!!!");
		} else if (choice == 2) {
			for (int i = 0; i < 3; i++) {
				System.out.print("가위바위보 중 하나 입력:");
				String input = sc.next();
				int rand = (int) (Math.random() * 3) + 1;
				
				result += gt.RockScissorsPaper(rand, input);

			}
			if (result>=2) System.out.println("### 사용자 승!!!");
			else System.out.println("### 컴퓨터 승!!!");

		} else if (choice == 3) {
			
			System.out.print("가위바위보 중 하나 입력:");
			String input = sc.next();
			int rand = (int) (Math.random() * 3) + 1;
			
			result += gt.RockScissorsPaper(rand, input);

			if (result==1) System.out.println("### 사용자 승!!!");
			else System.out.println("### 컴퓨터 승!!!");

		}

	}

	int RockScissorsPaper(int rand, String input) {
		int rst = 0;
		if ((rand == 1 && input.equals("가위")) || (rand == 2 && input.equals("바위"))
				|| (rand == 3 && input.equals("보"))) {
			System.out.println("비겼습니다!!!");
			rst++;
		} else if (rand == 1 && input.equals("바위") || (rand == 2 && input.equals("보"))
				|| (rand == 3 && input.equals("가위"))) {
			System.out.println("이겼습니다!!!");
			rst++;
		} else {
			System.out.println("졌습니다!!!");
		}
		return rst;
	}
}
