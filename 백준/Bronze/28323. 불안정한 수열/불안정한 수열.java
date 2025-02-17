import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = N;
        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < N ; i++) if ((arr[i - 1] + (arr[i] = Integer.parseInt(st.nextToken()))) % 2 == 0) K--;

        System.out.println(K);
    }
}
