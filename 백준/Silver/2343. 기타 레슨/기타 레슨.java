import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] videos = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int temp = 0;
            for (int i = 0 ; i < N ; i++) {
                if (temp + videos[i] > mid) {
                    if (videos[i] > mid) {
                        cnt = Integer.MAX_VALUE;
                        break;
                    }
                    temp = videos[i];
                    cnt++;
                } else {
                    temp += videos[i];
                }
            }

            if (cnt <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
