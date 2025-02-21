import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()) - 1;

            N = N % 28 < 15 ? (N % 28) + 1 : 29 - N % 28;

            String bit = String.format("%4s", Integer.toBinaryString(N)).replace(' ', '0');

            for (int i = 0; i < bit.length(); i++) {
                if (bit.charAt(i) == '1') {
                    sb.append("딸기");
                } else {
                    sb.append("V");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}