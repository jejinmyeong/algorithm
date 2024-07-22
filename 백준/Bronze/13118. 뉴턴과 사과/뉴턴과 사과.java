import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int [] p = new int[4];

        for (int i = 0 ; i < 4 ; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        boolean flag = false;

        for (int i = 0 ; i < 4 ; i++) {
            if (p[i] == x) {
                System.out.println(i + 1);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(0);
        }
    }
}