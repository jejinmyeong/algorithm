import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static String A, B;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = br.readLine();
        B = br.readLine();

        set = new HashSet<>();

        set.add(A);

        bt(B);

        System.out.println(0);
    }

    static void bt(String s) {
        if (s.length() == A.length()) {
            if (A.equals(s)) {
                System.out.println(1);
                System.exit(0);
            }

            return;
        }

        if (s.charAt(0) == 'B') {
            String next = s.substring(1);
            StringBuilder sb = new StringBuilder(next);
            bt(sb.reverse().toString());
        }

        if (s.charAt(s.length() - 1) == 'A') {
            String next = s.substring(0, s.length() - 1);
            bt(next);
        }
    }
}