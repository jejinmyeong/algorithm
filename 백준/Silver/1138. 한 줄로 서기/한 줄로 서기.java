import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] ans = new int[N];

        for (int i = 0 ; i < N ; i++) {
            int pos = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = 0 ; j < N ; j++) {
                if (ans[j] != 0) continue;

                if (cnt == pos) {
                    ans[j] = i + 1;
                    break;
                }

                if (ans[j] == 0) cnt++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}
