import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();

            if (num >= 620 && num <= 780) {
                sb.append("Red");
            } else if (num >= 590 && num < 620) {
                sb.append("Orange");
            } else if (num >= 570 && num < 590) {
                sb.append("Yellow");
            } else if (num >= 495 && num < 570) {
                sb.append("Green");
            } else if (num >= 450 && num < 495) {
                sb.append("Blue");
            } else if (num >= 425 && num < 450) {
                sb.append("Indigo");
            } else if (num >= 380 && num < 425) {
                sb.append("Violet");
            }

        sc.close();

        System.out.println(sb.toString());
    }
}