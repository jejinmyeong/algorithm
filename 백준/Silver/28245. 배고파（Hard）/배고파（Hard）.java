import java.io.*;
import java.util.*;

public class Main {
    static class Index {
        int x;
        int y;

        Index (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<Long, Index> map = new HashMap<>();
        List<Long> sums = new ArrayList<>();
        List<Long> arr = new ArrayList<>();

        for (int i = 0 ; (1L << i) <= 1e18 ; i++) {
            arr.add(1L << i);
        }

        int size = arr.size();

        for (int i = 0 ; i < size ; i++) {
            for (int j = i ; j < size ; j++) {
                long sum = arr.get(i) + arr.get(j);
                if (map.get(sum) == null) {
                    sums.add(sum);
                    map.put(sum, new Index(i, j));
                }
            }
        }

        Collections.sort(sums);

        for (int i = 0 ; i < N ; i++) {
            long M = Long.parseLong(br.readLine());

            for (int j = 1 ; j < sums.size() ; j++) {
                if (sums.get(j) > M) {
                    Index res = sums.get(j) - M >= M - sums.get(j - 1) ? map.get(sums.get(j - 1)) : map.get(sums.get(j));
                    sb.append(res.x + " " + res.y).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
