import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> arr = new LinkedList<>();

        for (int i = 0 ; i < N ; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        int i = 0;
        while (S > 0 && i < N) {
            int idx = moveAvailableMaxValue(arr, i, S, arr.get(i));

            if (idx == -1) {
                i++;
                continue;
            }

            int temp = arr.remove(idx);
            arr.add(i, temp);

            S -= idx - i;

            i++;
        }

        for (int r: arr) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }

    static int moveAvailableMaxValue(List<Integer> arr, int start, int move, int now) {
        int max = now;
        int idx = -1;
        for (int i = start + 1 ; i < arr.size() ; i++) {
            if (i - start > move) break;
            if (max < arr.get(i)) {
                max = arr.get(i);
                idx = i;
            }
        }

        return idx;
    }
}