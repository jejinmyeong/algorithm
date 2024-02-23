import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, K;
    static HashSet<String> set;
    static int [] arr;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        set = new HashSet<>();

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bt(0, "");

        System.out.println(set.size());
    }

    static void bt(int k, String temp) {
        if (k == K) {
            set.add(temp);
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            bt(k + 1, temp + String.valueOf(arr[i]));
            visited[i] = false;
        }
    }
}