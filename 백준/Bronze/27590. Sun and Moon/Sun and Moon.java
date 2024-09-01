import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ds = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int dm = Integer.parseInt(st.nextToken());
        int ym = Integer.parseInt(st.nextToken());

        int s = ys - ds;
        int m = ym - dm;

        while (s != m) {
            if (s < m) {
                s += ys;
            } else {
                m += ym;
            }
        }

        System.out.println(s);
    }
}
