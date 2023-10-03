import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        boolean flag = true;

        for (int i = 0 ; i < input.length() / 2 ; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println(1);
        else System.out.println(0);

    }
}
