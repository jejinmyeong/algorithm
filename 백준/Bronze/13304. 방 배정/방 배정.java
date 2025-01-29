import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] girls = new int[6];
        int [] boys = new int[6];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (S == 0) {
                girls[Y - 1]++;
            } else {
                boys[Y - 1]++;
            }
        }

        int rooms = 0;

        rooms += (girls[0] + girls[1] + boys[0] + boys[1]) % K == 0 ? (girls[0] + girls[1] + boys[0] + boys[1]) / K : (girls[0] + girls[1] + boys[0] + boys[1]) / K + 1;
        rooms += (girls[2] + girls[3]) % K == 0 ? (girls[2] + girls[3]) / K : (girls[2] + girls[3]) / K + 1;
        rooms += (girls[4] + girls[5]) % K == 0 ? (girls[4] + girls[5]) / K : (girls[4] + girls[5]) / K + 1;

        rooms += (boys[2] + boys[3]) % K == 0 ? (boys[2] + boys[3]) / K : (boys[2] + boys[3]) / K + 1;
        rooms += (boys[4] + boys[5]) % K == 0 ? (boys[4] + boys[5]) / K : (boys[4] + boys[5]) / K + 1;

        System.out.println(rooms);
    }
}
