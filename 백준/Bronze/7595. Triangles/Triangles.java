import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            for (int i = 1 ; i <= n ; i++) {
                for (int j = 0 ; j < i ; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
