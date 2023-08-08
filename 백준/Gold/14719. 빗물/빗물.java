import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] heights = new int[W];

        for (int i = 0 ; i < W ; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1 ; i < W - 1 ; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0 ; j < i ; j++) {
                left = Math.max(heights[j], left);
            }

            for (int j = i + 1 ; j < W ; j++) {
                right = Math.max(heights[j], right);
            }

            if (heights[i] < left && heights[i] < right) ans += Math.min(left, right) - heights[i];
        }
        
        System.out.println(ans);

    }
}