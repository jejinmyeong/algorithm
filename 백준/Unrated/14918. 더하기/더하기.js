const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const [ A, B ] = input[0].split(' ').map(Number);

    console.log(A + B);
}

main();