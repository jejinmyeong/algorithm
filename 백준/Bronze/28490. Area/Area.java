import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int maxArea = 0;

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int area = h * w;

            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }
}
