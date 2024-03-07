import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] jewels = new int[M];

        for (int i = 0 ; i < M ; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0 ; i < M ; i++) {
                cnt += (jewels[i] / mid);

                if (jewels[i] % mid != 0) {
                    cnt++;
                }
            }

            if (cnt > N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}