import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine();

            int N = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");

            for (int i = 0 ; i < N ; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if (sum.remainder(new BigInteger(String.valueOf(N))).equals(new BigInteger("0"))) sb.append("YES");
            else sb.append("NO");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}