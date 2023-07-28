import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] pay = new int[N];

        for (int i = 0 ; i < N ; i++) {
            pay[i] = Integer.parseInt(br.readLine());
        }

        int min = 0;
        int max = Integer.MAX_VALUE;

        while (min <= max) {
            int mid = (min + max) / 2;

            int cnt = 0;
            int now = 0;
            for (int i = 0 ; i < N ; i++) {
                if (now < pay[i]) {
                    now = mid;
                    cnt++;
                }

                now -= pay[i];

                // 사용할 금액을 뺐는데 now가 음수인 경우
                if (now < 0) {
                    cnt = M + 1;
                    break;
                }
            }

            // cnt 가 M보다 크다는 말은 한번에 인출한 돈의 액수가 적어서 여러번 인출했다는 것.
            // K의 크기를 키워야 됨
            if (cnt > M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(min);
    }
}