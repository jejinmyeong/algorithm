import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        boolean [] Ps = new boolean[14];
        boolean [] Ks = new boolean[14];
        boolean [] Hs = new boolean[14];
        boolean [] Ts = new boolean[14];

        int P = 13;
        int K = 13;
        int H = 13;
        int T = 13;

        for (int i = 0 ; i < input.length() / 3 ; i++) {
            String card = input.substring(i * 3, (i + 1) * 3);

            char shape = card.charAt(0);
            int num = Integer.parseInt(card.substring(1, 3));

            if (shape == 'P') {
                if (Ps[num]) {
                    System.out.println("GRESKA");
                    return;
                }

                P -= 1;
                Ps[num] = true;
            } else if (shape == 'K') {
                if (Ks[num]) {
                    System.out.println("GRESKA");
                    return;
                }

                K -= 1;
                Ks[num] = true;
            } else if (shape == 'H') {
                if (Hs[num]) {
                    System.out.println("GRESKA");
                    return;
                }

                H -= 1;
                Hs[num] = true;
            } else {
                if (Ts[num]) {
                    System.out.println("GRESKA");
                    return;
                }

                T -= 1;
                Ts[num] = true;
            }
        }

        System.out.println(P + " " + K + " " + H + " " + T);
    }
}
