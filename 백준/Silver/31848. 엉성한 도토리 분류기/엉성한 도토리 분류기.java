import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] a = new int[N];

        a[0] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < N ; i++) {
            a[i] = Math.max(a[i - 1], Integer.parseInt(st.nextToken()) + i);
        }

        int Q = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < Q; i++) {
            int s = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (a[mid] >= s) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            sb.append(start + 1).append(" ");
        }

        System.out.println(sb);
    }
}

