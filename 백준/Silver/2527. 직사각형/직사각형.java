import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 4;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            // d 유형
            if (x2 < x3 ||
                x1 > x4 ||
                y2 < y3 ||
                y1 > y4) {
                sb.append("d");
            }
            // c 유형
            else if (
                (x1 == x4 && y1 == y4) ||
                (x1 == x4 && y2 == y3) ||
                (x2 == x3 && y1 == y4) ||
                (x2 == x3 && y2 == y3)) {
                sb.append("c");
            }
            // b 유형
            else if (
                x1 == x4 ||
                x2 == x3 ||
                y1 == y4 ||
                y2 == y3
            ) {
                sb.append("b");
            } else sb.append("a");

            sb.append("\n");

        }

        System.out.print(sb);
    }
}