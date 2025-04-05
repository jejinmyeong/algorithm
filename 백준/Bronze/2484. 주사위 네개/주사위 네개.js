const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    let ans = 0;

    for (let i = 1 ; i <= N ; i++) {
        const [ a, b, c, d ] = input[i].split(' ').map(Number);

        if (a === b && b === c && c == d) ans = Math.max(ans, 50000 + a * 5000);
        else if (a === b && b === c) ans = Math.max(ans, 10000 + a * 1000);
        else if (b === c && c === d) ans = Math.max(ans, 10000 + b * 1000);
        else if (c === d && d === a) ans = Math.max(ans, 10000 + c * 1000);
        else if (d === a && a === b) ans = Math.max(ans, 10000 + d * 1000);
        else if (a === b) c === d ? ans = Math.max(ans, 2000 + a * 500 + c * 500) : ans = Math.max(ans, 1000 + a * 100);
        else if (a === c) b === d ? ans = Math.max(ans, 2000 + a * 500 + b * 500) : ans = Math.max(ans, 1000 + a * 100);
        else if (b === c) d === a ? ans = Math.max(ans, 2000 + b * 500 + d * 500) : ans = Math.max(ans, 1000 + b * 100);
        else if (b === d) a === c ? ans = Math.max(ans, 2000 + b * 500 + a * 500) : ans = Math.max(ans, 1000 + b * 100);
        else if (c === d) a === b ? ans = Math.max(ans, 2000 + c * 500 + a * 500) : ans = Math.max(ans, 1000 + c * 100);
        else if (d === a) b === c ? ans = Math.max(ans, 2000 + d * 500 + d * 500) : ans = Math.max(ans, 1000 + d * 100);
        else ans = Math.max(ans, Math.max(a, b, c, d) * 100);

    }

    console.log(ans);
}

main();