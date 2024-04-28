import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < H ; i++) {
            int c = -1;
            String line = br.readLine();
            for (int j = 0 ; j < W ; j++) {
                if (line.charAt(j) == 'c') {
                    c = j;
                    sb.append(0);
                } else {
                    if (c == -1) {
                        sb.append(-1);
                    } else {
                        sb.append(j - c);
                    }
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}