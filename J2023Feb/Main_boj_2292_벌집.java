package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_2292_벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 1;

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int s = 1;
        int e = 40000;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (N > 3 * (int) (Math.pow(mid, 2) + mid)) s = mid + 1;
            else e = mid - 1;
        }

        System.out.println(s + 1);
    }
}
