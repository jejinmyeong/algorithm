import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] L = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1_000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;
            
            int sum = 0;
            
            if (mid == 0) {
                sum = Integer.MAX_VALUE;
            } else {
                for (int i = 0 ; i < N ; i++) {
                    sum += L[i] / mid;
                }
            }

            if (sum < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}