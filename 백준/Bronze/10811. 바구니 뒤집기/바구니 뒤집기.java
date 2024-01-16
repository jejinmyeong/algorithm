import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] list = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            list[i] = i;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while (start < end) {
                int temp = list[start];
                list[start] = list[end];
                list[end] = temp;

                start++;
                end--;
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            sb.append(list[i]).append(" ");
        }

        System.out.println(sb);
    }
}