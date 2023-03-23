let N;

function solution(storey) {
    var answer = 0;
    
    N = storey.toString();
    
    let arr = new Array(N.length);
    
    for (let i = 0 ; i < N.length ; i++) {
        arr[i] = parseInt(N[i]);
    }
    
    for (let i = N.length - 1 ; i > 0 ; i--) {
        if (arr[i] > 5 || (arr[i] === 5 && arr[i - 1] >= 5)) {
            answer += 10 - arr[i];
            arr[i - 1]++;
        } else {
            answer += arr[i];
        }
    }
    
    if (arr[0] > 5) {
        answer += 11 - arr[0];
    } else {
        answer += arr[0];
    }
    
    
    return answer;
}
