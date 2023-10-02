import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            for (int j = i ; j < N ; j++) {
                sb.append(" ");
            }

            for (int j = 0 ; j < i * 2 - 1 ; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
