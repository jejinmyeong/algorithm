import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();


        int score[][] = new int[8][2];

        for (int i = 0; i < 8; i++) {
            score[i][0] = Integer.parseInt(br.readLine());
            score[i][1] = i + 1;
        }

        Arrays.sort(score, (o1, o2) -> o2[0] - o1[0]);

        ArrayList<Integer> index = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += score[i][0];
            index.add(score[i][1]);
        }

        Collections.sort(index);

        for(int i:index) {
            sb.append(i+" ");
        }

        System.out.println(sum);
        System.out.println(sb);
    }
}
