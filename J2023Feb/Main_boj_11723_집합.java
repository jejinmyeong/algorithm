package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_boj_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            String c = st.nextToken();

            if ("add".equals(c)) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if ("remove".equals(c)) {
                set.remove(Integer.parseInt(st.nextToken()));
            }
            else if ("check".equals(c)) {
                if (set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if ("toggle".equals(c)) {
                int v = Integer.parseInt(st.nextToken());
                if (set.contains(v)) set.remove(v);
                else set.add(v);
            }
            else if ("all".equals(c)) {
                for (int j = 1 ; j <= 20 ; j++) set.add(j);
            }
            else if ("empty".equals(c)) set.removeAll(set);
        }

        System.out.print(sb);
    }
}
