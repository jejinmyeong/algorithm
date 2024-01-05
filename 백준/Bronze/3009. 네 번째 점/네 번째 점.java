import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<Integer> px = new HashSet<>();
        HashSet<Integer> py = new HashSet<>();

        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (px.contains(x)) px.remove(x);
            else px.add(x);

            if (py.contains(y)) py.remove(y);
            else py.add(y);
        }

        System.out.println(px.toArray()[0] + " " + py.toArray()[0]);
    }
}