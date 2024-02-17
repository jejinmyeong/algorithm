import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long now = h * 60 * 60 + m * 60 + s;

        int time = Integer.parseInt(br.readLine());

        long next = now + time;

        final long max = 24 * 60 * 60;

        if (next >= max) next %= max;

        long nh = next / 60 / 60;

        next -= nh * 60 * 60;

        long nm = next / 60;

        next -= nm * 60;

        long ns = next;

        System.out.println(nh + " " + nm + " " + ns);

    }
}