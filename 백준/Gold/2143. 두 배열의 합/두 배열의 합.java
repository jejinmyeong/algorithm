import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int [] arr1 = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            if (map1.containsKey(arr1[i])) map1.put(arr1[i], map1.get(arr1[i]) + 1);
            else map1.put(arr1[i], 1);
        }

        for (int i = 0 ; i < N - 1 ; i++) {
            int sum = arr1[i];
            for (int j = i + 1 ; j < N ; j++) {
                sum += arr1[j];

                if (map1.containsKey(sum)) map1.put(sum, map1.get(sum) + 1);
                else map1.put(sum, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int [] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < M ; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            if (map2.containsKey(arr2[i])) map2.put(arr2[i], map2.get(arr2[i]) + 1);
            else map2.put(arr2[i], 1);
        }

        for (int i = 0 ; i < M - 1 ; i++) {
            int sum = arr2[i];
            for (int j = i + 1 ; j < M ; j++) {
                sum += arr2[j];

                if (map2.containsKey(sum)) map2.put(sum, map2.get(sum) + 1);
                else map2.put(sum, 1);
            }
        }

        long ans = 0;

        for (int left : map1.keySet()) {
            if (map2.containsKey(T - left)) ans += (long) map1.get(left) * map2.get(T - left);
        }

        System.out.println(ans);
    }
}
