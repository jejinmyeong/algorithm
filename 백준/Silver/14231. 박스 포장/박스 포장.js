const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main() {
    const N = input[0];
    const arr = input[1].split(' ').map(Number);

    const dp = [];

    for (let i = 0 ; i < N ; i++) {
        dp[i] = 1;
    }

    for (let i = 1 ; i < N ; i++) {
        for (let j = 0 ; j < i ; j++) {
            if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    console.log(Math.max(...dp));
}

main();