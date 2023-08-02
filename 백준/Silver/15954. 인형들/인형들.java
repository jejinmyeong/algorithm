import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double ans = Double.MAX_VALUE;

        for (int i = K ; i <= N ; i++) {
            for (int j = 0 ; j <= N - i ; j++) {
                double average = getAverage(j, i);
                double standardDeviation = getStandardDeviation(average, j, i);

                ans = Math.min(ans, standardDeviation);
            }
        }

        System.out.println(ans);
    }

    static double getAverage(int start, int cnt) {
        double sum = 0;

        for (int i = start ; i < start + cnt ; i++) {
            sum += arr[i];
        }

        return sum / cnt;
    }

    static double getStandardDeviation(double average, int start, int cnt) {
        double sum = 0;
        for (int i = start ; i < start + cnt ; i++) {
            sum += Math.pow(arr[i] - average, 2);
        }

        return Math.sqrt(sum / cnt);
    }
}