import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                continue;
            }

            int left = 0;
            int right = list.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid) >= num) right = mid;
                else left = mid + 1;
            }

            list.set(right, num);
        }

        System.out.println(list.size() - 1);

    }
}