import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SortedSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (set.contains(b)) {
                set.remove(b);
            }
        }

        sb.append(set.size()).append("\n");

        if (set.size() != 0) {
            for (int s: set) {
                sb.append(s).append(" ");
            }
        }

        System.out.println(sb);
    }
}