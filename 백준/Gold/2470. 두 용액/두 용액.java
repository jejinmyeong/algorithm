import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] solutions = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        while (left < right) {
            int sum = Math.abs(solutions[left] + solutions[right]);
            if (sum < min) {
                min = sum;
                l = solutions[left];
                r = solutions[right];
            }

            if (solutions[left] + solutions[right] > 0) right--;
            else left++;
        }

        System.out.println(l + " " + r);
    }
}