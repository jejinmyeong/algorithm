import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int mul = 1, N;
    static int [] ans;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            mul *= Integer.parseInt(st.nextToken());
        }

        ans = new int[N];
        backTracking(0, 1);

        if (flag) System.out.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        else System.out.println(-1);
    }

    private static boolean backTracking(int n, int temp) {
        if (n == N) {
            if (temp > mul) {
                flag = true;
                return true;
            }
            else return false;
        }

        for (int i = 0 ; i < 10 ; i++) {
            boolean res = backTracking(n + 1, temp * i);

            if (res) {
                ans[n] = i;
                return true;
            }
        }

        return false;
    }
}
