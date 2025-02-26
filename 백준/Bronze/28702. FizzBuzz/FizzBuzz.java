import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String i1 = br.readLine(), i2 = br.readLine(), i3 = br.readLine();

        int ans = -1;

        if (i1.chars().allMatch(Character::isDigit)) {
            ans = Integer.parseInt(i1) + 3;
        } else if (i2.chars().allMatch(Character::isDigit)) {
            ans = Integer.parseInt(i2) + 2;
        } else if (i3.chars().allMatch(Character::isDigit)) {
            ans = Integer.parseInt(i3) + 1;
        }

        System.out.println(ans % 3 == 0 && ans % 5 == 0 ? "FizzBuzz" : ans % 3 == 0 ? "Fizz" : ans % 5 == 0 ? "Buzz" : ans);
    }
}
