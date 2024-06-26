import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());

            if (height == 136) {
                ans += 1000;
            } else if (height == 142) {
                ans += 5000;
            } else if (height == 148) {
                ans += 10000;
            } else {
                ans += 50000;
            }
        }

        System.out.println(ans);
    }
}