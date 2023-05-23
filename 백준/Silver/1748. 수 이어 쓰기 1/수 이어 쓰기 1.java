import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long ans = 0;

        int full = (int) (Math.log(N) / Math.log(10));

        for (int i = 0 ; i < full ; i++) {
            int cnt = (int) (Math.pow(10, i) * 9);
            ans += (i + 1) *  cnt;
            N -= cnt;
        }

        ans += (full + 1) * N;

        System.out.println(ans);

    }
}
