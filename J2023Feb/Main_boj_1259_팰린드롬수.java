package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if ("0".equals(input)) break;

            char [] c = input.toCharArray();

            int mid = c.length / 2;
            boolean flag = true;
            for (int i = 0 ; i < mid ; i++) {
                if (c[i] != c[c.length - i - 1]) {
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }
}
