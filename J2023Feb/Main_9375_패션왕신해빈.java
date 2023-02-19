package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());

                String clothes = st.nextToken();
                String type = st.nextToken();

                if (!map.containsKey(type)) map.put(type, new ArrayList<>());

                map.get(type).add(clothes);
            }
            int cnt = 1;
            String [] ketSet = new String[map.size()];
            map.keySet().toArray(ketSet);

            for (String s : ketSet) {
                cnt *= map.get(s).size() + 1;
            }
            sb.append(cnt - 1).append("\n");
        }

        System.out.print(sb);
    }
}
