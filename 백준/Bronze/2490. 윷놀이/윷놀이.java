import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = 0;

            for (int j = 0 ; j < 4 ; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                sb.append("D");
            } else if (cnt == 1) {
                sb.append("C");
            } else if (cnt == 2) {
                sb.append("B");
            } else if (cnt == 3) {
                sb.append("A");
            } else {
                sb.append("E");
            }

            sb.append("\n");
        }

        System.out.print(sb);

    }
}