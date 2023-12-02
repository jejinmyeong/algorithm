import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        int start = 1;
        int end = M;

        int ans = 0;

        for (int i = 0 ; i < j ; i++) {
            int p = Integer.parseInt(br.readLine());
            // 떨어지는 사과 위치가 바구니 위치보다 오른쪽이라면
            if (p > end) {
                // p - end 값 만큼 이동
                int dist = p - end;
                ans += dist;
                start += dist;
                end += dist;
            }
            // 떨어지는 사과 위치가 바구니 위치보다 왼쪽이라면
            else if (p < start) {
                int dist = start - p;
                ans += dist;
                start -= dist;
                end -= dist;
            }
        }

        System.out.println(ans);
    }
}