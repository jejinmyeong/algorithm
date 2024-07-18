import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long R = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        long ans = 1;

        if (R % N == 0) {
            ans *= R / N;
        } else {
            ans *= R / N + 1;
        }

        if (C % N == 0) {
            ans *= C / N;
        } else {
            ans *= C / N + 1;
        }

        System.out.println(ans);
    }
}