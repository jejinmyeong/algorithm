import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        BigInteger [] fibonacci = new BigInteger[N + 1];

        fibonacci[0] = new BigInteger("0");
        fibonacci[1] = new BigInteger("1");

        for (int i = 2 ; i <= N ; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        System.out.println(fibonacci[N]);
    }
}