package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 5 ; i <= N ; i += 5) {
            int cnt = 0;
            int start = i;
            while (start % 5 == 0) {
                cnt++;
                start /= 5;
            }
            ans += cnt;
        }

        System.out.println(ans);
    }
}