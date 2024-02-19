import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Word implements Comparable<Word> {
        String word;
        int cnt;

        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt == o.cnt) {
                if (this.word.length() == o.word.length()) {
                    return this.word.compareTo(o.word);
                }

                return o.word.length() - this.word.length();
            }

            return o.cnt - this.cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0 ; i < N ; i++) {
            String word = br.readLine();

            if (word.length() < M) continue;

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        Word [] words = new Word[map.size()];

        int idx = 0;
        for (String w: map.keySet()) {
            words[idx++] = new Word(w, map.get(w));
        }

        Arrays.sort(words);

        for (Word word: words) {
            sb.append(word.word).append("\n");
        }

        System.out.print(sb);
    }
}