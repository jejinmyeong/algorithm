import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Animal {
        int x, y;

        Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] pos = new int[M];

        for (int i = 0 ; i < M ; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        Animal [] animals = new Animal[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            animals[i] = new Animal(x, y);
        }

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            Animal now = animals[i];

            int start = 0;
            int end = M - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (Math.abs(pos[mid] - now.x) + now.y <= L) {
                    ans++;
                    break;
                }

                if (pos[mid] < now.x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(ans);
    }
}