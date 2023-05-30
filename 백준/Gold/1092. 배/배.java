import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Integer [] weights = new Integer[N];

        for (int i = 0 ; i < N ; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> box = new ArrayList<>();

        for (int i = 0 ; i < M ; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(box, Collections.reverseOrder());

        if (weights[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int ans = 0;

        while (!box.isEmpty()) {
            int idx = 0;
            for(int i = 0 ; i < N ; i++) {
                if (idx == box.size()) break;
                else if (weights[i] >= box.get(idx)) box.remove(idx);
                else {
                    idx++;
                    i--;
                }
            }
            ans++;
        }

        System.out.println(ans);
    }
}