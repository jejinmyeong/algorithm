import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        while (min <= max) {
            int mid = (min + max) / 2;

            long temp = 0;
            for (int i = 0 ; i < N ; i++) {
                if (arr[i] < mid) temp += arr[i];
                else temp += mid;
            }

            if (temp <= M) min = mid + 1;
            else max = mid - 1;

        }

        System.out.println(max);

    }
}
