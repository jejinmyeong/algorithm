import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Pos> D = new HashMap<>();

        D.put("R", new Pos(1, 0));
        D.put("L", new Pos(-1, 0));
        D.put("B", new Pos(0, -1));
        D.put("T", new Pos(0, 1));
        D.put("RT", new Pos(1, 1));
        D.put("LT", new Pos(-1, 1));
        D.put("RB", new Pos(1, -1));
        D.put("LB", new Pos(-1, -1));

        Pos nk = new Pos(king.charAt(0) - 'A', king.charAt(1) - '1');
        Pos ns = new Pos(stone.charAt(0) - 'A', stone.charAt(1) - '1');

        for (int i = 0 ; i < N ; i++) {
            String com = br.readLine();

            Pos d = D.get(com);

            int nx = nk.x + d.x;
            int ny = nk.y + d.y;

            if (isOverflow(nx, ny)) {
                continue;
            }

            if (ns.x == nx && ns.y == ny) {
                int nsx = ns.x + d.x;
                int nsy = ns.y + d.y;

                if (isOverflow(nsx, nsy)) {
                    continue;
                }

                ns = new Pos(nsx, nsy);
            }

            nk = new Pos(nx, ny);
        }

        System.out.println((char) (nk.x + 'A') + "" + (nk.y + 1));
        System.out.println((char) (ns.x + 'A') + "" + (ns.y + 1));
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 8 || ny >= 8;
    }
}