import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long x = Integer.parseInt(br.readLine());

            sb.append(2 * x - 1).append("\n");
        }

        System.out.print(sb);
    }
}
