import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Store {
        int d, l;

        Store (int d, int l) {
            this.d = d;
            this.l = l;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        Store [] stores = new Store[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            stores[i] = new Store(d, l);
        }

        st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            int sd = stores[i].d;
            int sl = stores[i].l;

            if (d == sd) {
                ans += Math.abs(l - sl);
            } else {
                if (d == 1 && sd == 2 || d == 2 && sd == 1) {
                    ans += Math.min(l + H + sl, W - l + H + W - sl);
                } else if (d == 3 && sd == 4 || d == 4 && sd == 3) {
                    ans += Math.min(l + W + sl, H - l + W + H - sl);
                } else if (d == 1 && sd == 4) {
                    ans += W - l + sl;
                } else if(d == 4 && sd == 1) {
                    ans += W - sl + l;
                } else if (d == 4 && sd == 2) {
                    ans += H - l + W - sl;
                } else if (d == 2 && sd == 4) {
                    ans += H - sl + W - l;
                } else if (d == 2 && sd == 3) {
                    ans += l + H - sl;
                } else if(d == 3 && sd == 2) {
                    ans += sl + H - l;
                } else if (d == 3 && sd == 1 || d == 1 && sd == 3) {
                    ans += l + sl;
                }
            }
        }

        System.out.println(ans);
    }
}