package dailyExercise;

public class DigitTest1 {
	public static void main(String[] args) {

		int c = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j < i) {
					System.out.printf(" " + " " + " ");
				} else {
					System.out.printf("%-3d", c);
					c++;
				}
			}
			System.out.println();
		}
	}
}
