import java.math.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String p = st.nextToken();
            String c = st.nextToken();

            if ("enter".equals(c)) {
                set.add(p);
            } else {
                set.remove(p);
            }
        }

        List<String> res = set.stream().collect(Collectors.toList());
        Collections.sort(res, Collections.reverseOrder());

        for (String s : res) {
            System.out.println(s);
        }
    }
}