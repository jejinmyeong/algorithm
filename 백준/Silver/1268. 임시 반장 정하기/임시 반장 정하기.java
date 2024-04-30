import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][5];
        boolean [][] visited = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < 5 ; i++) {
            List<Integer>[] temp = new ArrayList[10];

            for (int j = 0 ; j < 10 ; j++) {
                temp[j] = new ArrayList<>();
            }

            for (int j = 0 ; j < N ; j++) {
                temp[arr[j][i]].add(j);
            }

            for (int j = 0 ; j < N ; j++) {
                int num = arr[j][i];

                for (int k = 0 ; k < temp[num].size() ; k++) {
                    if (j == temp[num].get(k)) continue;
                    visited[j][temp[num].get(k)] = true;
                }
            }
        }

        int max = 0;
        int idx = 0;

        for (int i = 0 ; i < N ; i++) {
            int cnt = 0;
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j]) cnt++;
            }

            if (max < cnt) {
                max = cnt;
                idx = i;
            }
        }

        System.out.println(idx + 1);

    }
}