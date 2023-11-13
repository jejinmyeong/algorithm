import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> res = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            String [] tokens = br.readLine().split("[a-z]");

            for (String t : tokens) {
                if ("".equals(t)) continue;
                res.add(new BigInteger(t));
            }
        }

        Collections.sort(res);

        for (BigInteger r : res) {
            System.out.println(r);
        }
    }
}