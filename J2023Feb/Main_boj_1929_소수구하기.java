package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        boolean [] nums = new boolean[e + 1];

        nums[0] = true;
        nums[1] = true;

        for (int i = 2 ; i <= e/2 ; i++) {
            for (int j = i * 2 ; j <= e ; j += i) {
                nums[j] = true;
            }
        }

        for (int i = s ; i <= e ; i++) {
            if (!nums[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}
