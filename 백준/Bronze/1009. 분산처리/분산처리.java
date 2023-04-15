import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                sb.append(1).append("\n");
            } else if (a == 2) {
                sb.append((int) Math.pow(2, b % 4 == 0 ? 4 : b % 4) % 10).append("\n");
            } else if (a == 3) {
                sb.append((int) Math.pow(3, b % 4 == 0 ? 4 : b % 4) % 10).append("\n");
            } else if (a == 4) {
                sb.append((int) Math.pow(4, b % 2 == 0 ? 2 : b % 2) % 10).append("\n");
            } else if (a == 5) {
                sb.append(5).append("\n");
            } else if (a == 6) {
                sb.append(6).append("\n");
            } else if (a == 7) {
                sb.append((int) Math.pow(7, b % 4 == 0 ? 4 : b % 4) % 10).append("\n");
            } else if (a == 8) {
                sb.append((int) Math.pow(8, b % 4 == 0 ? 4 : b % 4) % 10).append("\n");
            } else if (a == 9) {
                sb.append((int) Math.pow(9, b % 2 == 0 ? 2 : b % 2) % 10).append("\n");
            } else if (a == 0) {
                sb.append(10).append("\n");
            }
        }
        System.out.print(sb);
    }
}