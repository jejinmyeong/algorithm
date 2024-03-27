import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = r1 ; i <= r2 ; i++) {
            for (int j = c1 ; j <= c2 ; j++ ) {
                int d = Math.max(Math.abs(i), Math.abs(j));
                int val = (int) Math.pow(2 * d - 1, 2);

                if (i == d && j == d) {
                    val = (int) Math.pow(2 * d + 1, 2);
                } else if (Math.abs(j) == d && j > 0) {
                    val += d - i;
                } else if (Math.abs(j) == d && j < 0) {
                    val += 5 * d + i;
                } else if (Math.abs(i) == d && i > 0) {
                    val += 7 * d + j;
                } else if (Math.abs(i) == d && i < 0) {
                    val += 3 * d - j;
                }

                max = Math.max(max, val);
            }
        }

        int length = String.valueOf(max).length();

        for (int i = r1 ; i <= r2 ; i++) {
            for (int j = c1 ; j <= c2 ; j++ ) {
                int d = Math.max(Math.abs(i), Math.abs(j));
                int val = (int) Math.pow(2 * d - 1, 2);

                if (i == d && j == d) {
                    val = (int) Math.pow(2 * d + 1, 2);
                } else if (Math.abs(j) == d && j > 0) {
                    val += d - i;
                } else if (Math.abs(j) == d && j < 0) {
                    val += 5 * d + i;
                } else if (Math.abs(i) == d && i > 0) {
                    val += 7 * d + j;
                } else if (Math.abs(i) == d && i < 0) {
                    val += 3 * d - j;
                }

                String valToString = String.valueOf(val);

                for (int l = 0 ; l < length - valToString.length() ; l++) {
                    sb.append(" ");
                }
                sb.append(val + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}