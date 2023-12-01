import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int value = arr[i] = Integer.parseInt(st.nextToken());

            if (value < list.get(list.size() - 1)) list.add(value);
            else {
                int left = 0;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) <= value) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                list.set(right, value);
            }
        }

        System.out.println(N - list.size() + 1);
    }
}
