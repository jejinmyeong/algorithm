package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_10775_공항 {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G + 1];

        for (int i = 1 ; i <= G ; i++) {
            parents[i] = i;
        }

        for (int p = 0 ; p < P ; p++) {
            int g = Integer.parseInt(br.readLine());

            if (find(g) == 0) {
                System.out.println(p);
                return;
            }
            union(parents[g] - 1, parents[g]);
        }

        System.out.println(P);
        return;
    }

    static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parents[b] = a;
    }
    static int find (int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}