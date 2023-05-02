import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int ans = 0;
        int sum = arr[0];

        while (left <= right) {
            if (sum == M) ans++;

            if (right == N && sum <= M) break;

            if (sum <= M) sum += arr[right++];
            else sum -= arr[left++];
        }

        System.out.println(ans);
    }
}