import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    static int ans, R;
    static ArrayList<Integer> [] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        nodes = new ArrayList[N];

        for (int i = 0 ; i < N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        int start = -1;

        for (int i = 0 ; i < N ; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (p == -1) {
                start = i;
                continue;
            }
            nodes[p].add(i);
        }

        R = Integer.parseInt(br.readLine());

        if (R != start) dfs(start);

        System.out.println(ans);
    }

    static void dfs (int idx) {
        if (nodes[idx].size() == 0) {
            ans++;
            return;
        }

        for (int i = 0 ; i < nodes[idx].size() ; i++) {
            int c = nodes[idx].get(i);
            
            if (c == R) {
                if (nodes[idx].size() == 1) ans++;
                continue;
            }

            dfs(c);
        }
    }
}