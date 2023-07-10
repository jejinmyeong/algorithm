import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<int []> dp = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            if (!map.containsKey(a)) {
                map.put(a, dp.size());

                dp.add(new int[str.length() + 1]);

                for (int j = 1 ; j <= str.length() ; j++) {
                    char now = str.charAt(j - 1);

                    if (a == now) {
                        dp.get(map.get(a))[j] = dp.get(map.get(a))[j - 1] + 1;
                    } else {
                        dp.get(map.get(a))[j] = dp.get(map.get(a))[j - 1];
                    }
                }
            }

            sb.append(dp.get(map.get(a))[end] - dp.get(map.get(a))[start - 1]).append("\n");
        }

        System.out.print(sb);
    }
}