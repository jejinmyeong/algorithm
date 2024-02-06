import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int divider = 2;
            int cnt = 0;

            while (N != 1) {
                if (N % divider == 0) {
                    N /= divider;
                    cnt++;
                } else {
                    if (cnt > 0) {
                        sb.append(divider).append(" ").append(cnt).append("\n");
                    }
                    divider++;
                    cnt = 0;
                }
            }

            if (cnt > 0) {
                sb.append(divider).append(" ").append(cnt).append("\n");
            }
        }

        System.out.print(sb);

    }
}