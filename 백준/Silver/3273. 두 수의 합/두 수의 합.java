import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int ans = 0;

        while (start < end) {
            if (arr[start] + arr[end] == X) {
                ans++;
            }

            if (arr[start] + arr[end] <= X) start++;
            else end--;
        }

        System.out.println(ans);

    }
}
