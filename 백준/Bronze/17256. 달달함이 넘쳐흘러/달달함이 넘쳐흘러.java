import java.io.*;
import java.util.*;

public class Main {
    static class Cake {
        int x, y, z;

        Cake (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Cake a = new Cake(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        Cake c = new Cake(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        sb.append(c.x - a.z).append(" ").append(c.y / a.y).append(" ").append(c.z - a.x);

        System.out.println(sb);
    }
}
