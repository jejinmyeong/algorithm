import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;

        int ans = Integer.MAX_VALUE;

        while (left <= right && right < N) {
            if (arr[right] - arr[left] < M) {
                right++;
            } else {
                ans = Math.min(ans, arr[right] - arr[left]);
                left++;
            }
        }

        System.out.println(ans);
    }
}