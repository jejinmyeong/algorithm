import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger total = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());
        BigInteger two = new BigInteger("2");
        //(1)

        BigInteger klaudia = (total.subtract(diff)).divide(two).add(diff);
        //(2)
        BigInteger natalia = (total.subtract(diff)).divide(two);
        //(3)

        System.out.println(klaudia);
        System.out.println(natalia);
    }
}
