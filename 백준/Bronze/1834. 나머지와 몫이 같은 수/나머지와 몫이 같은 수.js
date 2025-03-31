const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = BigInt(input[0]);

    let ans = (N + 1n) * N * (N - 1n) / 2n;

    console.log(ans.toString());
}

main();