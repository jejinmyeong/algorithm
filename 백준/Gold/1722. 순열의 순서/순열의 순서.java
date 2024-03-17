import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());

        long [] factorial = new long[21];
        factorial[0] = 1;

        for (int i = 1 ; i <= 20 ; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int [] arr = new int[N + 1];
        boolean [] visited = new boolean[N + 1];

        if (c == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    if (visited[j]) continue;
                    if (factorial[N - i] < k) {
                        k -= factorial[N - i];
                    } else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 1 ; i <= N ; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            long k = 1;
            for (int i = 1 ; i <= N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j < arr[i] ; j++) {
                    if (visited[j]) continue;
                    k += factorial[N - i];
                }
                visited[arr[i]] = true;
            }
            sb.append(k);
        }

        System.out.println(sb);
    }
}