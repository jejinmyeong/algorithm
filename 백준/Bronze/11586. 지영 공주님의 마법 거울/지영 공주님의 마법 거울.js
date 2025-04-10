const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);
    const K = parseInt(input[N + 1]);

    let ans = '';

    for (let i = 1 ; i <= N ; i++) {
        if (K === 1) {
            ans = ans.concat(input[i] + '\n');
        } else if (K === 2) {
            ans = ans.concat(input[i].split('').reverse().join('') + '\n');
        } else {
            ans = input[i].concat('\n' + ans);
        }
    }

    console.log(ans);
}

main();