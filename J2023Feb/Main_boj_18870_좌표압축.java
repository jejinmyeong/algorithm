package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_boj_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> tree = new TreeSet<>();

        int [] pos = new int[N];

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            pos[i] = n;
            tree.add(n);
        }

        Object[] seq = tree.toArray();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < seq.length ; i++) {
            map.put((int) seq[i], i);
        }

        for (int i = 0 ; i < N ; i++) {
            sb.append(map.get(pos[i])).append(" ");
        }

        System.out.print(sb);
    }
}
