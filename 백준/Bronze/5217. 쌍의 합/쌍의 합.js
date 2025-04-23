const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const t = parseInt(input[0]);

    let ans = '';

    for (let i = 1 ; i <= t ; i++) {
        const N = parseInt(input[i]);

        ans = ans.concat('Pairs for ' + N + ": ");
        for (let j = 1 ; j < N / 2 ; j++) {
            if (j !== 1) ans = ans.concat(', ');
            ans = ans.concat(j + " " + (N - j))
        }
        ans = ans.concat('\n');
    }

    console.log(ans);
}

main();