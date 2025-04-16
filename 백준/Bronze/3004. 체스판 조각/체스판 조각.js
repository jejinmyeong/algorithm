const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    if (N % 2 === 0) {
        console.log(((N + 2) / 2) * ((N + 2) / 2));
    } else {
        console.log((N + 3) / 2 * (N + 1) / 2);
    }
}

main();