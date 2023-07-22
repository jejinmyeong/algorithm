import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int[L];

        for (int i = 0 ; i < L ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());
        int start = 0, end = 1001;

        for (int i = 0 ; i < L ; i++) {
            if (arr[i] < N) {
                start = Math.max(start, arr[i]);
            } else if (arr[i] > N) {
                end = Math.min(end, arr[i]);
            } else {
                System.out.println(0);
                return;
            }
        }

        int cnt = 0;

        for (int i = start + 1; i <= N ; i++) {
            for (int j = N ; j < end ; j++) {
                if (i != j) cnt++;
            }
        }

        System.out.println(cnt);
    }
}