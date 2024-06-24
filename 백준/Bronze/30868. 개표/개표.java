import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            while (n >= 5) {
                sb.append("++++").append(" ");

                n -= 5;
            }

            for (int i = 0 ; i < n ; i++) {
                sb.append("|");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}