import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int [] cnt = new int[26];

        for (int i = 0 ; i < str.length() ; i++) {
            int now = str.charAt(i) - 'A';

            cnt[now]++;
        }

        int ans = 0;

        for (int i = 1 ; i < N ; i++) {
            String str2 = br.readLine();

            boolean chance = false;
            if (Math.abs(str.length() - str2.length()) > 1) continue;
            else if (str.length() <= str2.length()) chance = true;
            int [] cnt2 = new int[26];

            boolean isSimilar = true;

            for (int j = 0 ; j < str2.length() ; j++) {
                int now = str2.charAt(j) - 'A';
                if (cnt2[now] + 1 <= cnt[now]) {
                    cnt2[now]++;
                    continue;
                }

                if (chance) chance = false;
                else {
                    isSimilar = false;
                    break;
                }
            }

            if (isSimilar) ans++;
        }

        System.out.println(ans);
    }
}