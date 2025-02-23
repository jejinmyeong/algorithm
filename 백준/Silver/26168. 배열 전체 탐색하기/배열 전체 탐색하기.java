import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long [] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            if (t == 1) {
                int res = binarySearch(arr, Long.parseLong(st.nextToken()), true);
                sb.append(n - res).append("\n");
            } else if (t == 2) {
                int res = binarySearch(arr, Long.parseLong(st.nextToken()), false);
                sb.append(n - res).append("\n");
            } else if (t == 3) {
                int res1 = binarySearch(arr, Long.parseLong(st.nextToken()), true);
                int res2 = binarySearch(arr, Long.parseLong(st.nextToken()), false);
                sb.append(res2 - res1).append("\n");
            }
        }

        System.out.print(sb);

    }

    private static int binarySearch(long[] arr, long target, boolean equal) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (equal) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return start;
    }
}