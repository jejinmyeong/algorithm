import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(Math.min((M + 1) / 2, 4));
        } else if (N >= 3) {
            if (M < 7) {
                System.out.println(Math.min(M, 4));
            } else {
                System.out.println(M - 2);
            }
        }
    }
}