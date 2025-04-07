const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);
    const arr = input[1].split(' ').map(Number);

    let min = arr[0];
    let max = arr[0];
    let ans = 0;

    for (let i = 1 ; i < N ; i++) {
        if (arr[i] <= max) {
            ans = Math.max(ans, max - min);
            min = arr[i];
            max = arr[i];
        } else max = arr[i];
    }

    ans = Math.max(ans, max - min);

    console.log(ans);
}

main();