import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (!map.containsKey(a)) map.put(a, 1);
            else map.put(a, map.get(a) + 1);
        }

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (map.containsKey(b)) {
                cnt += map.get(b) + 1;
                map.put(b, 0);
            }
        }

        System.out.println(N + M - cnt);
    }
}
