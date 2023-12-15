import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double start = 0.0;
        double end = 1_000_000_000;

        while (start < end) {
            double mid = (start + end) / 2;

            if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) {
                if (start == mid) break;
                start = mid;
            } else {
                if (end == mid) break;
                end = mid;
            }
        }

        System.out.println(start);
    }
}
