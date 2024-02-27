import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer [] arr = new Integer[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0 ; i < N ; i++) {
            ans += Math.max(arr[i] - i, 0);
        }

        System.out.println(ans);
    }
}