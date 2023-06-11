import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean [] visited = new boolean[1001];

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];
        
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            int x = arr[i];

            if (visited[x]) continue;
            ans++;
            for (int j = 0 ; j < L ; j++) {
                if (x + j > 1000) break;
                visited[x + j] = true;
            }
        }

        System.out.println(ans);
    }
}