import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new LinkedList<>();

        list.add(Integer.MAX_VALUE);

        for (int i = 0 ; i < N ; i++) {
            if (list.get(list.size() - 1) > arr[i]) {
                list.add(arr[i]);
                continue;
            }

            int s = 0 ;
            int e = list.size() - 1;

            while (s < e) {
                int mid = (s + e) / 2;

                if (list.get(mid) > arr[i]) s = mid + 1;
                else e = mid;
            }

            list.set(s, arr[i]);

        }

        System.out.println(list.size() - 1);
    }
}