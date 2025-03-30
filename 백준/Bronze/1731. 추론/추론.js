const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);
    if (parseInt(input[3]) - parseInt(input[2]) === parseInt(input[2]) - parseInt(input[1])) {
        console.log(parseInt(input[input.length - 1]) + parseInt(input[2]) - parseInt(input[1]))
    } else {
        console.log(parseInt(input[input.length - 1]) * (parseInt(input[2]) / parseInt(input[1])))
    }

}

main();