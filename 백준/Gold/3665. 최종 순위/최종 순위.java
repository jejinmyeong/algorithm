import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1 ; t <= T ; t++) {
            int N = Integer.parseInt(br.readLine());

            int [] arr = new int[N + 1];
            int [] cnt = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1 ; i <= N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> [] list = new ArrayList[N + 1];

            for (int i = 1 ; i <= N ; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 1 ; i <= N ; i++) {
                int front = arr[i];
                for (int j = i + 1 ; j <= N ; j++) {
                    int back = arr[j];
                    list[front].add(back);
                    cnt[back]++;
                }
            }

            int M = Integer.parseInt(br.readLine());

            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());

                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                if (list[front].contains(back)) {
                    list[front].remove((Integer) back);
                    list[back].add(front);
                    cnt[front]++;
                    cnt[back]--;
                } else {
                    list[back].remove((Integer) front);
                    list[front].add(back);
                    cnt[front]--;
                    cnt[back]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1 ; i <= N ; i++) {
                if (cnt[i] == 0) queue.add(i);
            }

            boolean flag = false;
            String res = "";

            for (int i = 1 ; i <= N ; i++) {
                if (queue.size() > 1) {
                    sb.append("?").append("\n");
                    flag = true;
                    break;
                } else if (queue.size() == 0) {
                    sb.append("IMPOSSIBLE").append("\n");
                    flag = true;
                    break;
                } else {
                    int now = queue.poll();
                    res += now + " ";
                    for (int j = 0 ; j < list[now].size() ; j++) {
                        int back = list[now].get(j);
                        cnt[back]--;
                        if (cnt[back] == 0) queue.offer(back);
                    }
                }
            }

            if (flag) continue;

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

}