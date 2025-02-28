import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            boolean flag = true;

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (map.get(c) % 3 == 0) {
                    if (s.length() <= j + 1 || s.charAt(j + 1) != c) {
                        flag = false;
                        break;
                    } else {
                        j++;
                    }
                }
            }

            if (flag) {
                sb.append("OK");
            } else {
                sb.append("FAKE");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}