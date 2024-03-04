import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Shortcut implements Comparable<Shortcut>{
        int x, y, l;

        Shortcut(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }

        @Override
        public int compareTo(Shortcut o) {
            if (this.x == o.x) {
                if (this.y == o.y) {
                    return this.l - o.l;
                }

                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int [] load = new int[10001];

        for (int i = 0 ; i <= 10000 ; i++) {
            load[i] = i;
        }

        Shortcut [] shortcuts = new Shortcut[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            shortcuts[i] = new Shortcut(x, y, l);
        }

        Arrays.sort(shortcuts);

        for (int i = 0 ; i < N ; i++) {
            int x = shortcuts[i].x;
            int y = shortcuts[i].y;
            int l = shortcuts[i].l;

            load[y] = Math.min(load[y], load[x] + l);

            for (int j = y + 1 ; j <= 10000 ; j++) {
                load[j] = Math.min(load[y] + j - y, load[j]);
            }
        }
        
        System.out.println(load[D]);

    }
}