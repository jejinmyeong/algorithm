import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        for (int i = 2 ; i <= Math.sqrt(N) ; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N != 1) sb.append(N).append("\n");

        System.out.print(sb);
    }
}