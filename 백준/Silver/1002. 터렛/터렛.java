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

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 같은 위치에 있고 r이 다른 경우 -> 0 같은 경우 -> -1
            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    sb.append(-1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                continue;
            }

            // p1과 p2의 거리
            double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            
            // 하나의 원이 다른쪽에 포함되는 경우
            if (r1 >= d && r1 >= r2) {
                if (r1 > d + r2) sb.append(0);
                else if (r1 == d + r2) sb.append(1);
                else sb.append(2);
            } else if (r2 >= d && r2 >= r1) {
                if (r2 > d + r1) sb.append(0);
                else if (r2 == d + r1) sb.append(1);
                else sb.append(2);
            } else {
                // d가 r1 + r2 보다 작은 경우 두점에서 만남.
                if (d < r1 + r2) sb.append(2);
                // d가 r1 + r2 와 같은 경우 한점에서 만남
                else if (d == r1 + r2) sb.append(1);
                // d가 r1 + r2 보다 큰 경우 안만남.
                else sb.append(0);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}