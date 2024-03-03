import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        String calculator = br.readLine();
        BigInteger B = new BigInteger(br.readLine());

        if ("+".equals(calculator)) {
            A = A.add(B);
        }

        else if ("*".equals(calculator)) {
            A = A.multiply(B);
        }

        System.out.println(A);

    }
}