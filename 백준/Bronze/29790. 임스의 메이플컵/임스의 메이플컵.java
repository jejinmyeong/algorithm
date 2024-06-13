import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean c1 = condition1(N);
        boolean c2 = condition2(U, L);

        if (c1 && c2) {
            System.out.println("Very Good");
        } else if (c1) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }

    static boolean condition1(int N) {
        return N >= 1000;
    }

    static boolean condition2(int U, int L) {
        return U >= 8000 || L >= 260;
    }
}