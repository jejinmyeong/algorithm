const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const arr = Array(26).fill(0);
    let max = 0;

    for (let i = 0 ; i < input.length ; i++) {
        for (let c of input[i].split('')) {
            if (c === ' ') continue;
            arr[c.charCodeAt(0) - 97]++;

            max = Math.max(max, arr[c.charCodeAt(0) - 97]);
        }
    }

    let ans = '';

    for (let i = 0 ; i < 26 ; i++) {
        if (arr[i] === max) ans += String.fromCharCode(i + 97);
    }

    console.log(ans)
}

main();