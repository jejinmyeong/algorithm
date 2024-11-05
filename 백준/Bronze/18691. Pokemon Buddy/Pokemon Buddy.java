import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int total = 0;

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(g == 1) {
                total = e - c;
            }else if(g == 2) {
                total = (e - c) * 3;
            }else if(g == 3) {
                total = (e - c) * 5;
            }

            if(c >= e) {
                total = 0;
            }
            System.out.println(total);
        }
    }
}
