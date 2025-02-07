import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] sum = new int[10001];
        int [] cnt = new int[10001];

        for (int i = 1 ; i <= N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[num] += num;
            cnt[num]++;
        }

        for (int i = 1 ; i <= 10000 ; i++) {
            sum[i] += sum[i - 1];
            cnt[i] += cnt[i - 1];
        }

        int min = Integer.MAX_VALUE;

        int ans = 0;

        for (int  i = 1 ; i <= 10000 ; i++) {
            if (cnt[i] == cnt[i - 1]) continue;
            int res = (i * cnt[i - 1] - sum[i - 1]) + (sum[10000] - sum[i] - i * (cnt[10000] - cnt[i]));

            if (min > res) {
                min = res;
                ans = i;
            }
        }

        System.out.println(ans);

    }
}
