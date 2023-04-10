import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);

        for (int i = 0 ; i < N ; i++) {
            int v = Integer.parseInt(br.readLine());

            if (list.get(list.size() - 1) < v) list.add(v);
            else {
                int left = 0;
                int right = list.size();

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= v) right = mid;
                    else left = mid + 1;
                }

                list.set(left, v);
            }
        }

        System.out.println(N - (list.size() - 1));
    }
}