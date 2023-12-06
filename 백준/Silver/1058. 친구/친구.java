import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [][] isFriend = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();

            for (int j = 0 ; j < N ; j++) {
                if (line.charAt(j) == 'Y') {
                    isFriend[i][j] = true;
                }
            }
        }

        Set<Integer> [] friends = new Set[N];

        for (int i = 0 ; i < N ; i++) {
            friends[i] = new HashSet<>();
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (!isFriend[i][j]) continue;
                friends[i].add(j);
                for (int k = 0 ; k < N ; k++) {
                    if (i == k || !isFriend[j][k]) continue;
                    friends[i].add(k);
                }
            }
        }

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            ans = Math.max(ans, friends[i].size());
        }

        System.out.println(ans);
    }
}
