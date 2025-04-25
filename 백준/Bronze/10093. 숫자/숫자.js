const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const [ A, B ] = input[0].split(' ').map(Number).sort((a, b) => a - b);

    let ans = '';

    if (A === B) {
        console.log(0);
        return;
    }

    ans = ans.concat((B - A - 1) + '\n');

    for (let i = A + 1 ; i < B ; i++) {
        ans = ans.concat(i + ' ');
    }

    console.log(ans);
}

main();