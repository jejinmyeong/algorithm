import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d1, h1, m1, total = 0;

        d1 = Integer.parseInt(st.nextToken());
        h1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());

        if(d1 < 11) {
            System.out.println("-1");
        }else if(d1 == 11) {
            if(h1 < 11) {
                System.out.println("-1");
            }else if(h1 == 11) {
                if(m1 >= 11) {
                    total += m1 - 11;
                    System.out.println(total);
                }else {
                    System.out.println("-1");
                }
            }else if(h1 > 11) {
                if(m1 >= 11) {
                    total += (h1 - 11) * 60 + m1 - 11;
                    System.out.println(total);
                }else {
                    total += (h1 - 12) * 60 + 60 - 11 + m1;
                    System.out.println(total);
                }
            }
        }else if(d1 > 11) {
            if(h1 > 11) {
                if(m1 >= 11) {
                    total += (d1 - 11) * 24 * 60 + (h1 - 11) * 60 + m1 - 11;
                    System.out.println(total);
                }else if(m1 < 11) {
                    total += (d1 - 11) * 24 * 60 + (h1 - 12) * 60 + 60 - 11 + m1;
                    System.out.println(total);
                }
            }else if(h1 == 11) {
                if(m1 >= 11) {
                    total += (d1 - 11) * 24 * 60 + m1 - 11;
                    System.out.println(total);
                }else if(m1 < 11) {
                    total += (d1 - 12) * 24 * 60 + 23 * 60 + 60 - 11 + m1;
                    System.out.println(total);
                }
            }else if(h1 < 11) {
                if(m1 >= 11) {
                    total += (d1 - 12) * 24 * 60 + (24 - 11 + h1) * 60 + m1 - 11;
                    System.out.println(total);
                }else if(m1 < 11) {
                    total += (d1 - 12) * 24 * 60 + (24 - 12 + h1) * 60 + 60 - 11 + m1;
                    System.out.println(total);
                }
            }
        }
    }
}
