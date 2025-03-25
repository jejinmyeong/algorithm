const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main () {
    console.log(parseInt(input[0], 16));
}

main();