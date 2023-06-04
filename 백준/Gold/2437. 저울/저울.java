import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[0] != 1) {
            System.out.println(1);
            return;
        }

        int sum = arr[0];

        for (int i = 1 ; i < N ; i++) {
            if (sum + 1 < arr[i]) {
                System.out.println(sum + 1);
                return;
            }

            sum += arr[i];
        }

        System.out.println(sum + 1);
    }
}