package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        long [] s = new long [50];

        s[0] = 1;

        for (int i = 1 ; i < 50 ; i++) {
            s[i] = (s[i - 1] * 31) % 1234567891;
        }

        long ans = 0;
        String input = br.readLine();

        for (int i = 0 ; i < L ; i++) {
            ans = (ans + (input.charAt(i) + 1 - 'a') * s[i]) % 1234567891;
        }

        System.out.println(ans);
    }
}
