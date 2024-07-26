import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            BigInteger n = new BigInteger(br.readLine());
            sb.append(n.multiply(n)).append("\n");
        }

        System.out.print(sb);
    }
}