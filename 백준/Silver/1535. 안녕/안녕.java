import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Person {
        int L, J;

        Person(int L, int J) {
            this.L = L;
            this.J = J;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Person [] persons = new Person[N + 1];

        StringTokenizer L = new StringTokenizer(br.readLine());
        StringTokenizer J = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            persons[i] = new Person(Integer.parseInt(L.nextToken()), Integer.parseInt(J.nextToken()));
        }

        int [][] dp = new int[N + 1][100];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j < 100 ; j++) {
                if (j - persons[i].L < 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - persons[i].L] + persons[i].J);
            }
        }

        System.out.println(dp[N][99]);
    }
}