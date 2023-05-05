import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        long ans = 0;

        for (int i = 0 ; i < N ; i++) {
            long now = Long.parseLong(br.readLine());
            if (map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
            } else {
                map.put(now, 1);
            }

            if (cnt < map.get(now)) {
                cnt = map.get(now);
                ans = now;
            } else if (cnt == map.get(now)) {
                ans = Math.min(ans, now);
            }
        }

        System.out.println(ans);

    }
}
