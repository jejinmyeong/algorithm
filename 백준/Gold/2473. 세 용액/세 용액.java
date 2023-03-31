import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        long [] arr = new long[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long ml = 0, mm = 0, mr = 0;

        for (int i = 0 ; i < N - 2 ; i++) {
            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                long sum = arr[i] + arr[start] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ml = arr[i];
                    mm = arr[start];
                    mr = arr[end];
                }

                if (sum > 0) end--;
                else start++;
            }
        }

        System.out.println(ml + " " + mm + " " + mr);
    }
}
