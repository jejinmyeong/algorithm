import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int [] fibonacci = new int[N + 1];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 2;

        for (int i = 3 ; i <= N ; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        int before = 0;
        int ans = 1;
        for (int i = 0 ; i < M ; i++) {
            int now = Integer.parseInt(br.readLine());

            ans *= fibonacci[now - before - 1];
            before = now;
        }

        ans *= fibonacci[N - before];

        System.out.println(ans);

    }
}