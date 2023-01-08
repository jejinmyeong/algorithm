package dailyExercise;

public class DigitTest2 {
	public static void main(String[] args) {
		int c = 1;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((i <= j && 5 - i > j) || (i >= j && 4 - i <= j)) {
					System.out.printf("%3d", c);
					c++;
				} else {
					System.out.print(" " + " " + " ");
				}
			}
			System.out.println();
		}
	}
}
