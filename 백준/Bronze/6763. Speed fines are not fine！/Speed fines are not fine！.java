import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine());
        int cur = Integer.parseInt(br.readLine());
        int gap = cur - limit;

        if (gap <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (gap <= 20) {
            System.out.printf("You are speeding and your fine is $%d.", 100);
        } else if (gap <= 30) {
            System.out.printf("You are speeding and your fine is $%d.", 270);
        } else {
            System.out.printf("You are speeding and your fine is $%d.", 500);
        }
    }
}
