import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String ans = null;

        for (int i = 1 ; i < input.length() - 1 ; i++) {
            for (int j = i + 1 ; j < input.length() ; j++) {
                StringBuilder sb1 = new StringBuilder(input.substring(0, i));
                StringBuilder sb2 = new StringBuilder(input.substring(i, j));
                StringBuilder sb3 = new StringBuilder(input.substring(j));

                String sub1 = sb1.reverse().toString();
                String sub2 = sb2.reverse().toString();
                String sub3 = sb3.reverse().toString();

                String now = sub1 + sub2 + sub3;

                if (ans == null) ans = now;
                else {
                    if (ans.compareTo(now) > 0) {
                        ans = now;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}