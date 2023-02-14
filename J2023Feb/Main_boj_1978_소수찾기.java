package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean [] nums = new boolean[1001];

        nums[0] = true;
        nums[1] = true;

        for (int i = 2 ; i <= 500 ; i++) {
            for (int j = i * 2 ; j <= 1000 ; j += i) {
                nums[j] = true;
            }
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            if (nums[Integer.parseInt(st.nextToken())]) cnt++;
        }

        System.out.print(N - cnt);
    }
}
