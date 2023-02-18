package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_boj_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();

            for (int i = 0 ; i < k ; i++) {
                st = new StringTokenizer(br.readLine());

                String c = st.nextToken();
                int v = Integer.parseInt(st.nextToken());

                if ("I".equals(c)) {
                        if (tree.containsKey(v)) tree.put(v, tree.get(v) + 1);
                        else tree.put(v, 1);
                }
                else if ("D".equals(c)) {
                    if (tree.isEmpty()) continue;
                    if (v == -1) {
                        if (tree.get(tree.firstKey()) == 1) tree.remove(tree.firstKey());
                        else tree.put(tree.firstKey(), tree.get(tree.firstKey()) - 1);
                    }
                    else {
                        if (tree.get(tree.lastKey())== 1) tree.remove(tree.lastKey());
                        else tree.put(tree.lastKey(), tree.get(tree.lastKey()) - 1);
                    }
                }
            }
            if (tree.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(tree.lastKey() + " " + tree.firstKey()).append("\n");
        }
        System.out.print(sb);
    }
}
