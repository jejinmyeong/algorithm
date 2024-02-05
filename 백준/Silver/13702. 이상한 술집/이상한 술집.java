import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] ml = new int[N];

        for (int i = 0 ; i < N ; i++) {
            ml[i] = Integer.parseInt(br.readLine());
        }

        long start = 0;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            int cnt = 0;
            if (mid == 0) {
                cnt = Integer.MAX_VALUE;
            } else {
                for (int i = 0 ; i < N ; i++) {
                    cnt += ml[i] / mid;
                }
            }

            if (cnt >= K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);

    }
}