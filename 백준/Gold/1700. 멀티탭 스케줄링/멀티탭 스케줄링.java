import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> [] queue = new Queue[K + 1];
        int [] flugs = new int[K];
        for (int i = 1 ; i <= K ; i++) {
            queue[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < K ; i++) {
            flugs[i] = Integer.parseInt(st.nextToken());
            queue[flugs[i]].offer(i);
        }

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i = 0 ; i < K ; i++) {
            queue[flugs[i]].poll();

            if (set.size() < N || set.contains(flugs[i])) {
                set.add(flugs[i]);
                continue;
            }

            // 모든 플러그에 전기제품이 다 꽂혀있고, 다른 제품을 꽂아야 하는 경우
            // 현재 플러그에 꽂혀있는 제품 중에 제일 나중에 쓸 애를 뽑음
            int idx = -1;
            int day = 0;
            for (int s : set) {
                if (queue[s].isEmpty()) {
                    idx = s;
                    day = Integer.MAX_VALUE;
                    break;
                } else if (day < queue[s].peek()) {
                    idx = s;
                    day = queue[s].peek();
                }
            }

            set.remove(idx);
            set.add(flugs[i]);
            ans++;
        }

        System.out.println(ans);

    }
}

