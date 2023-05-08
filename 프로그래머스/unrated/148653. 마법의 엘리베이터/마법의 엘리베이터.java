class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int 몫 = storey / 10;
            int 나머지 = storey % 10;
            if (나머지 < 5 || (나머지 == 5 && 몫 % 10 < 5) ) answer += 나머지;
            else {
                answer += 10 - 나머지;
                몫 += 1;
            }
            
            storey = 몫;
        }
        
        return answer;
    }
}