import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long [] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

            for (int j = L - 1 ; j < R ; j++) {
                arr[j] += X;
            }

            Arrays.sort(arr);
        }

        for (long a: arr) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);

    }
}

