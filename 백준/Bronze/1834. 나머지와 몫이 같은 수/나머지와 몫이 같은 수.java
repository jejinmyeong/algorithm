import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger ans = new BigInteger(String.valueOf(N - 1)).multiply(new BigInteger(String.valueOf(N))).multiply(new BigInteger(String.valueOf(N + 1))).divide(new BigInteger("2"));

        System.out.println(ans);
    }
}

