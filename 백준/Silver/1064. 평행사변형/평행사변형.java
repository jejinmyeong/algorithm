import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xa = Integer.parseInt(st.nextToken());
        int ya = Integer.parseInt(st.nextToken());
        int xb = Integer.parseInt(st.nextToken());
        int yb = Integer.parseInt(st.nextToken());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());

        if (xa == xb && xa == xc || ya == yb && ya == yc) {
            System.out.println(-1.0);
            return;
        }


        if (ya == yb) {
            if ((double)(xa - xc) / (ya - yc) == (double)(xb - xc) / (yb - yc)) {
                System.out.println(-1.0);
                return;
            }
        } else if (ya == yc) {
            if ((double)(xa - xb) / (ya - yb) == (double)(xb - xc) / (yb - yc)) {
                System.out.println(-1.0);
                return;
            }
        } else {
            if ((double)(xa - xc) / (ya - yc) == (double)(xb - xa) / (yb - ya)) {
                System.out.println(-1.0);
                return;
            }
        }

        double ab = Math.sqrt(Math.pow(xa - xb, 2) + Math.pow(ya - yb, 2));
        double ac = Math.sqrt(Math.pow(xa - xc, 2) + Math.pow(ya - yc, 2));
        double bc = Math.sqrt(Math.pow(xb - xc, 2) + Math.pow(yb - yc, 2));

        double sum = ab + ac + bc;

        double min = (sum - Math.max(ab, Math.max(ac, bc))) * 2;
        double max = (sum - Math.min(ab, Math.min(ac, bc))) * 2;

        System.out.println(max - min);
    }
}
