import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] strings = new PriorityQueue[7];

        int ans = 0;

        for (int i = 0 ; i <= 6 ; i++) {
            strings[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int string = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!strings[string].isEmpty() && strings[string].peek() > fret) {
                ans++;
                strings[string].poll();
            }
            if (strings[string].isEmpty() || strings[string].peek() != fret) {
                ans++;
                strings[string].offer(fret);
            }

        }

        System.out.println(ans);
    }
}