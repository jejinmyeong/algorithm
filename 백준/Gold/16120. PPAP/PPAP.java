import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        if ("P".equals(input)) {
            System.out.println("PPAP");
            return;
        }

        if (input.length() < 4 || input.charAt(input.length() - 1) == 'A') {
            System.out.println("NP");
            return;
        }

        int cnt = 0;

        for (int i = 0 ; i < input.length() - 1 ; i++) {
            char now = input.charAt(i);

            if (now == 'P') {
                cnt++;
            } else {
                if (cnt >= 2 && input.charAt(i + 1) == 'P') {
                    cnt -= 2;
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        if (cnt == 0) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }

    }
}