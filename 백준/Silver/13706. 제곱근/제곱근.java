import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());
        BigInteger start = new BigInteger("1");
        BigInteger end = N;

        while (start.compareTo(end) <= 0) {
            BigInteger mid = start.add(end).divide(new BigInteger("2"));

            int res = mid.multiply(mid).compareTo(N);

            if (res > 0) end = mid.subtract(new BigInteger("1"));
            else start = mid.add(new BigInteger("1"));
        }

        System.out.println(end);
    }
}

