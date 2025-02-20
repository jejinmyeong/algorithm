import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Integer [] burger = new Integer[B];

        int sum = 0;

        for (int i = 0; i < B; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            sum += burger[i];
        }

        Arrays.sort(burger, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        Integer [] side = new Integer[C];

        for (int i = 0; i < C; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            sum += side[i];
        }

        Arrays.sort(side, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        Integer [] drink = new Integer[D];

        for (int i = 0; i < D; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
            sum += drink[i];
        }

        Arrays.sort(drink, Collections.reverseOrder());

        System.out.println(sum);

        for (int i = 0 ; i < Math.min(B, Math.min(C, D)) ; i++) {
            sum -= (burger[i] + side[i] + drink[i]) * 10 / 100;
        }

        System.out.println(sum);

    }
}