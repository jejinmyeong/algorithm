import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int _N = Math.abs(N);

        int [] fibonacci = new int[2_000_001];

        fibonacci[1_000_000] = 0;
        fibonacci[1_000_001] = 1;

        for (int i = 2 ; i <= _N ; i++) {
            fibonacci[1_000_000 + i] = (fibonacci[1_000_000 + i - 1] + fibonacci[1_000_000 + i - 2]) % 1_000_000_000;
        }

        for (int i = 1 ; i <= _N ; i++) {
            fibonacci[1_000_000 - i] = (fibonacci[1_000_000 - i + 2] - fibonacci[1_000_000 - i + 1]) % 1_000_000_000;
        }

        int ans = fibonacci[1_000_000 + N];

        System.out.println(Integer.compare(ans, 0));
        System.out.println(Math.abs(ans));
    }
}