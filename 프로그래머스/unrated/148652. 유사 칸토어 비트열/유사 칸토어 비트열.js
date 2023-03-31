let N, L, R;

function solution(n, l, r) {
    var answer = 0;
    
    // 5로 나눴을 때 나머지가 2이거나 5의 제곱승으로 나눴을 때 몫이 2인 친구들
    
    for (let i = l - 1 ; i <= r - 1 ; i++) {
        let now = i;
        let flag = true;
        while(now != 0) {
            if (now % 5 === 2) {
                flag = false;
                break;
            }
            now = Math.floor(now / 5);
        }
        
        if (flag) {
            answer++;
        }
    }
    
    return answer;
}
// 11011
// 1101111011000001101111011 10 ~ 14     35 ~ 39 5로 나누면 7    60 ~ 64    
// 110111101100000110111101111011110110000011011110110000000000000000000000000