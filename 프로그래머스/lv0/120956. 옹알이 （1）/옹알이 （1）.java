class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String [] word = {"aya", "ye", "woo", "ma"};
        
        loop: for (int i = 0 ; i < babbling.length ; i++) {
            boolean [] visited = new boolean [babbling[i].length()];
            subLoop: for (int j = 0 ; j < word.length ; j++) {
                int index = babbling[i].indexOf(word[j]);
                if (index == -1) continue;
                for (int k = 0 ; k < word[j].length() ; k++) {
                    if (visited[index + k] == true) {
                        for (int l = 0 ; l < k ; k++) {
                            visited[index + l] = false;
                            continue subLoop;
                        }
                    }
                    visited[index + k] = true;
                }
            }
            for (int j = 0 ; j < babbling[i].length() ; j++) {
                if (!visited[j]) continue loop;
            }
            answer++;
        }
        
        return answer;
    }
}