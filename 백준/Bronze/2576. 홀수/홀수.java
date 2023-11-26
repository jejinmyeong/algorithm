import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0 ; i < 7 ; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num % 2 != 0) {
                sum += num;
                min = Math.min(min, num);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}