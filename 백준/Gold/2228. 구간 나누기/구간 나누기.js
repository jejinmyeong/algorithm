const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main () {
    const [ N, M ] = input[0].split(' ').map(Number);

    const arr = Array(N + 1);
    const sum = Array(N + 1);
    const dp = Array.from({ length: N + 1 }, () => Array(M + 1).fill(-Infinity))

    arr[0] = 0;
    sum[0] = 0;

    for (let i = 0 ; i <= N ; i++) dp[i][0] = 0;

    for (let i = 1 ; i <= N ; i++) {
        arr[i] = parseInt(input[i]);
        sum[i] = sum[i - 1] + arr[i];
    }
    

    dp[1][1] = arr[1];
    
    for (let n = 2 ; n <= N ; n++) {
        for (let m = 1 ; m <= M ; m++) {
            dp[n][m] = dp[n - 1][m];
            
            let min = 0;
            
            if (m === 1) min = -1;
            
            for (let k = n - 2 ; k >= min ; k--) {
                if (k < 0) dp[n][m] = Math.max(dp[n][m], sum[n]);
                else dp[n][m] = Math.max(dp[n][m], dp[k][m - 1] + sum[n] - sum[k + 1]);
            }
        }
    }
    
    console.log(dp[N][M]);

}

main();