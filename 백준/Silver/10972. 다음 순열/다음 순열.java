import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;

        for (int i = N - 1 ; i > 0 ; i--) {
            if (arr[i] > arr[i - 1]) {
                int p = 0;
                for (int j = N - 1 ; j >= i ; j--) {
                    if (arr[i - 1] < arr[j]) {
                        p = j;
                        break;
                    }
                }

                int temp = arr[i - 1];
                arr[i - 1] = arr[p];
                arr[p] = temp;

                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(-1);
            return;
        }

        for (int i = 0 ; i <= idx ; i++) {
            sb.append(arr[i]).append(" ");
        }

        for (int i = N - 1 ; i > idx ; i--) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}

