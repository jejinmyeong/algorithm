import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int ans = -1;
        int max = 0;

        for (int n = 1 ; n <= N ; n++) {
            st = new StringTokenizer(br.readLine());

            int [] arr = new int[5];
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            int temp = 0;
            for (int i = 0 ; i < 3 ; i++) {
                for (int j = i + 1 ; j < 4 ; j++) {
                    for (int k = j + 1 ; k < 5 ; k++) {
                        temp = Math.max(temp, (arr[i] + arr[j] + arr[k]) % 10);
                    }
                }
            }

            if (temp >= max) {
                max = temp;
                ans = n;
            }
        }

        System.out.println(ans);

    }
}