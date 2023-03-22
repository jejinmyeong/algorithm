import java.io.*;
import java.util.*;

public class Main {
    static class Pos implements Comparable<Pos> {
        int x, y;
        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Pos [] pos = new Pos[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pos);

        int ans = 0;

        int lastPos = 0;

        for (int i = 0 ; i < N ; i++) {
            if (pos[i].x > lastPos) {
                lastPos = pos[i].x;
            }

            if (pos[i].y > lastPos) {
                while (pos[i].y > lastPos) {
                    lastPos += L;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
