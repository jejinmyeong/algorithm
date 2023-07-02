import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        Integer[] rank = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rank, Collections.reverseOrder());

        if (rank[N - 1] >= S && N == P) {
            System.out.println(-1);
            return;
        }

        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (rank[mid] > S) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left + 1);
    }
}

