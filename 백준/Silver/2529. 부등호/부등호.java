import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String [] arr;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = st.nextToken();
        }

        visited = new boolean[10];
        for (int i = 9 ; i >= 0 ; i--) {
            visited[i] = true;
            if (findMaxValue(0, i, String.valueOf(i))) break;
            visited[i] = false;
        }

        visited = new boolean[10];
        for (int i = 0 ; i < 10 ; i++) {
            visited[i] = true;
            if (findMinValue(0, i, String.valueOf(i))) break;
            visited[i] = false;
        }
    }

    static boolean findMaxValue(int cnt, int now, String temp) {
        if (cnt == N) {
            System.out.println(temp);
            return true;
        }

        for (int i = 9 ; i >= 0 ; i--) {
            if (visited[i]) continue;
            if ("<".equals(arr[cnt]) && now < i) {
                visited[i] = true;
                if (findMaxValue(cnt + 1, i, temp + i)) return true;
                visited[i] = false;
            } else if (">".equals(arr[cnt]) && now > i) {
                visited[i] = true;
                if (findMaxValue(cnt + 1, i , temp + i)) return true;
                visited[i] = false;
            }
        }

        return false;
    }

    static boolean findMinValue(int cnt, int now, String temp) {
        if (cnt == N) {
            System.out.println(temp);
            return true;
        }

        for (int i = 0 ; i < 10 ; i++) {
            if (visited[i]) continue;
            if ("<".equals(arr[cnt]) && now < i) {
                visited[i] = true;
                if (findMinValue(cnt + 1, i, temp + i)) return true;
                visited[i] = false;
            } else if (">".equals(arr[cnt]) && now > i) {
                visited[i] = true;
                if (findMinValue(cnt + 1, i , temp + i)) return true;
                visited[i] = false;
            }
        }

        return false;
    }
}
