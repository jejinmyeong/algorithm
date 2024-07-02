import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lv = Integer.parseInt(st.nextToken());
        String hit = st.nextToken();

        if ("perfect".equals(hit)) System.out.println(lv * 1000);
        else if ("great".equals(hit)) System.out.println(lv * 600);
        else if ("cool".equals(hit)) System.out.println(lv * 400);
        else if ("bad".equals(hit)) System.out.println(lv * 200);
        else System.out.println(0);
    }
}
