import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String [] file = br.readLine().split("\\.");

            if (map.containsKey(file[1])) {
                map.put(file[1], map.get(file[1]) + 1);
            } else {
                map.put(file[1], 1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((s1, s2) -> s1.compareTo(s2));

        for (String key: keys) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.print(sb);

    }
}