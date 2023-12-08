import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (map.containsKey(now)) {
                map.replace(now, map.get(now) + 1);
            } else {
                map.put(now, 1);
            }
        }

        ArrayList<Integer> v = new ArrayList<>(map.keySet());

        Collections.sort(v, (a, b) -> map.get(b) - map.get(a));

        for (int i = 0 ; i < v.size() ; i++) {
            for (int j = 0 ; j < map.get(v.get(i)) ; j++) {
                sb.append(v.get(i)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
