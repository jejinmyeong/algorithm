import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> rank1 = new LinkedList<>();

        for (int i = 1 ; i <= N ; i++) {
            int r = Integer.parseInt(br.readLine());

            rank1.add(r - 1, i);
        }

        rank1 = rank1.subList(0, M);

        List<Integer> rank2 = new LinkedList<>();

        for (int i = M - 1 ; i >= 0 ; i--) {
            int r = Integer.parseInt(br.readLine());
            rank2.add(r - 1, rank1.get(i));
        }

        for (int i = 0 ; i < 3 ; i++) {
            sb.append(rank2.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
