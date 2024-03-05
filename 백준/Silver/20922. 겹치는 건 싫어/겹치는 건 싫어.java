import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] cnt = new int[100001];

        int start = 0;
        int end = 0;

        int ans = 1;

        while (start <= end) {
            if (cnt[arr[end]] < K) {
                cnt[arr[end]]++;
                end++;
            } else {
                cnt[arr[start]]--;
                start++;
            }

            ans = Math.max(ans, end - start);
            
            if (end == N) {
                break;
            }
        }

        System.out.println(ans);
    }
}