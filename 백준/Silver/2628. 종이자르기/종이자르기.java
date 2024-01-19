import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> w_slice = new ArrayList<>();
        ArrayList<Integer> h_slice = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (flag == 0) {
                w_slice.add(pos);
            } else {
                h_slice.add(pos);
            }
        }

        w_slice.add(0);
        h_slice.add(0);
        w_slice.add(W);
        h_slice.add(H);

        Collections.sort(w_slice);
        Collections.sort(h_slice);

        int maxW = 0;
        int maxH = 0;

        for (int i = 0 ; i < w_slice.size() - 1 ; i++) {
            maxW = Math.max(maxW, w_slice.get(i + 1) - w_slice.get(i));
        }

        for (int i = 0 ; i < h_slice.size() -1 ; i++) {
            maxH = Math.max(maxH, h_slice.get(i + 1) - h_slice.get(i));
        }

        System.out.println(maxH * maxW);
    }
}