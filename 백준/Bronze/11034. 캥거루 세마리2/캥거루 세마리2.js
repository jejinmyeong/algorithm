const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    for (let i = 0 ; i < input.length ; i++) {
        const [ A, B, C ] = input[i].split(' ').map(Number);

        let max = Math.max(C - B, B - A);

        console.log(max - 1)
    }
}

main();