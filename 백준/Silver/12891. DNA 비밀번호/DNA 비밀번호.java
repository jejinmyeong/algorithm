import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int [] ACGT = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < 4 ; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        int [] cnt = new int[4];

        for (int i = 0 ; i < M ; i++) {
            char now = str.charAt(i);
            if (now == 'A') cnt[0]++;
            else if (now == 'C') cnt[1]++;
            else if (now == 'G') cnt[2]++;
            else cnt[3]++;
        }

        int ans = 0;

        if (cnt[0] >= ACGT[0] && cnt[1] >= ACGT[1] && cnt[2] >= ACGT[2] && cnt[3] >= ACGT[3]) ans++;

        for (int i = M ; i < N ; i++) {
            char before = str.charAt(i - M);

            if (before == 'A') cnt[0]--;
            else if (before == 'C') cnt[1]--;
            else if (before == 'G') cnt[2]--;
            else cnt[3]--;

            char now = str.charAt(i);
            if (now == 'A') cnt[0]++;
            else if (now == 'C') cnt[1]++;
            else if (now == 'G') cnt[2]++;
            else cnt[3]++;

            if (cnt[0] >= ACGT[0] && cnt[1] >= ACGT[1] && cnt[2] >= ACGT[2] && cnt[3] >= ACGT[3]) ans++;
        }

        System.out.println(ans);
    }
}