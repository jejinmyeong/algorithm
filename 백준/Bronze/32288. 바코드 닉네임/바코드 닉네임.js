var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main() {
    let [ n, S ] = input;

    S = S.replaceAll('l', 'L');
    S = S.replaceAll('I', 'i');

    console.log(S)
}

main();