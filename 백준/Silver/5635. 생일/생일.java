import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Info implements Comparable<Info> {
        String name;
        long timestamp;

        Info(String name, long timestamp) {
            this.name = name;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Info o) {
            return Long.compare(o.timestamp, this.timestamp);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Info [] peoples = new Info[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int dd = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int yyyy = Integer.parseInt(st.nextToken());

            long timestamp = new Date(yyyy, mm - 1, dd).getTime();

            peoples[i] = new Info(name, timestamp);
        }

        Arrays.sort(peoples);

        System.out.println(peoples[0].name);
        System.out.println(peoples[N - 1].name);
    }
}
