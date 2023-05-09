import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int [] nums = new int[N];

            for (int i = 0 ; i < N ; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;

            for (int i = 0 ; i < N - 1 ; i++) {
                for (int j = i + 1 ; j < N ; j++) {
                    res += gcd(nums[i], nums[j]);
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
