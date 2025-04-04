const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    let ans = 0;

    for (let i = 1 ; i <= N ; i++) {
        const [ a, b, c ] = input[i].split(' ').map(Number);

        if (a === b && b === c) ans = Math.max(ans, 10000 + a * 1000);
        else if (a === b) ans = Math.max(ans, 1000 + a * 100);
        else if (b === c) ans = Math.max(ans, 1000 + b * 100);
        else if (a === c) ans = Math.max(ans, 1000 + c * 100);
        else ans = Math.max(ans, Math.max(a, b, c) * 100);

    }

    console.log(ans);
}

main();