package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_boj_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> list = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0 ; i < N ; i++) {
            list.add(br.readLine());
        }

        for (int i = 0 ; i < M ; i++) {
            String input = br.readLine();
            if (list.contains(input)) ans.add(input);
        }

        Collections.sort(ans);

        sb.append(ans.size()).append("\n");

        for (String s : ans) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
