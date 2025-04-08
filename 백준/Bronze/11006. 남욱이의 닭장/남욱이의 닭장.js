const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const T = parseInt(input[0]);

    let ans = '';

    for (let t = 1 ; t <= T ; t++) {
        const [ N, M ] = input[t].split(' ').map(Number);

        ans = ans.concat((2 * M - N) + ' ' + (N - M) + '\n');
    }

    console.log(ans);
}

main();