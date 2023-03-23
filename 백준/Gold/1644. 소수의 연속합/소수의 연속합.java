import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean [] isPrimeNumber = new boolean[N + 1];

        Arrays.fill(isPrimeNumber, true);

        for (int i = 2 ; i <= Math.sqrt(N) ; i++) {
            for (int j = i * i ; j <= N ; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 2 ; i <= N ; i++) {
            if (isPrimeNumber[i]) arr.add(i);
        }

        int [] sum = new int[arr.size() + 1];

        sum[0] = 0;
        int M = arr.size() + 1;

        for (int i = 1 ; i < M ; i++) {
            sum[i] = arr.get(i - 1) + sum[i - 1];
        }

        int start = 0;
        int end = 0;

        while(end < M) {
            int temp = sum[end] - sum[start];
            if (temp == N) {
                ans++;
                end++;
                start++;
            } else if (temp < N) {
                end++;
            } else {
                start++;
            }
        }

        System.out.println(ans);
    }
}
