const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const [ A, B ] = input[0].split(' ').map(Number).sort((a, b) => a - b);;

    let ans = (B - A) * (B - A + 1) / 2;
    ans += A * (B - A + 1);

    console.log(ans)
}

main();