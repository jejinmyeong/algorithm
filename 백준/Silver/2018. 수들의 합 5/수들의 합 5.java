import java.util.*;
        import java.io.*;
        import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;

        int ans = 0;

        while (left <= right) {
            if (sum < N) {
                right++;
                sum += right;
                continue;
            }

            if (sum == N) ans++;
            
            sum -= left;
            left++;
        }

        System.out.println(ans);
    }
}