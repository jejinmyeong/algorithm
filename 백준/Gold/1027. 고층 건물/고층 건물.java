import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            int cnt = 0;

            if (i != N - 1) {
                cnt++;
                double max = arr[i + 1] - arr[i];
                for (int j = i + 2 ; j < N ; j++) {
                    double k = (arr[j] - arr[i]) / (double)(j - i);
                    if (max < k) {
                        max = k;
                        cnt++;
                    }
                }
            }

            if (i != 0) {
                cnt++;
                double min = arr[i] - arr[i - 1];
                for (int j = i - 2 ; j >= 0 ; j--) {
                    double k = (arr[i] - arr[j]) / (double)(i - j);
                    if (min > k) {
                        min = k;
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}