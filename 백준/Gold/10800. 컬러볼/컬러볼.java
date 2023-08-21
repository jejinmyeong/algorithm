import java.util.*;
import java.io.*;

public class Main {
    static class Ball {
        int color, size, idx;

        Ball(int color, int size, int idx) {
            this.color = color;
            this.size = size;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        Ball [] balls = new Ball[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            balls[i] = new Ball(color, size, i);
        }

        Arrays.sort(balls, (o1, o2) -> {return o1.size - o2.size;});

        int [] results = new int[N];
        int [] colors = new int[N + 1];
        int sum = 0;

        for (int i = 0 ; i < N ; i++) {
            Ball now = balls[i];

            sum += now.size;
            colors[now.color] += now.size;

            int sameSize = 0;

            for (int j = i - 1 ; j >= 0 ; j--) {
                if (balls[j].size != now.size) break;
                if (balls[j].size == now.size && balls[j].color != now.color) {
                    sameSize++;
                }
            }

            results[now.idx] = sum - colors[now.color] - sameSize * now.size;
        }

        for (int i = 0 ; i < N ; i++) {
            sb.append(results[i]).append("\n");
        }

        System.out.print(sb);
    }
}