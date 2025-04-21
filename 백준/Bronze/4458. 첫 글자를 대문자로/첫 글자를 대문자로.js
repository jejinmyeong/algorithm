const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    let ans = '';

    for (let i = 1 ; i <= N ; i++) {
        const str = input[i];

        ans = ans.concat(str.toUpperCase().charAt(0) + str.substring(1) + '\n');
    }

    console.log(ans);
}

main();