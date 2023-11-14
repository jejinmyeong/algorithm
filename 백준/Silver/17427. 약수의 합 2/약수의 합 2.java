import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (long i = 1 ; i <= N ; i++) {
            ans += i * (N / i);
        }

        System.out.println(ans);
    }
}