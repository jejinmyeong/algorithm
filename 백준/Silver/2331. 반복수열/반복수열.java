import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long P = Integer.parseInt(st.nextToken());

        HashMap<Long, Integer> map = new HashMap<>();

        map.put(A, 0);

        int idx = 0;
        while (true) {
            long now = 0;
            while (A != 0) {
                now += (long) Math.pow(A % 10, P);
                A /= 10;
            }

            if (map.containsKey(now)) {
                System.out.println(map.get(now));
                return;
            }

            map.put(now, ++idx);
            A = now;
        }
    }
}