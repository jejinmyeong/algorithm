import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int [] dp = new int[y + 1];
        
        Arrays.fill(dp, 987654321);
        dp[x] = 0;
        if (x + n <= y) dp[x + n] = 1;
        if (x * 2 <= y) dp[x * 2] = 1;
        if (x * 3 <= y) dp[x * 3] = 1;
        
        for (int i = x + 1 ; i <= y ; i++) {
            if (i - n >= 0) dp[i] = Math.min(dp[i], dp[i - n] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        
        return dp[y] == 987654321 ? -1 : dp[y];
    }
}