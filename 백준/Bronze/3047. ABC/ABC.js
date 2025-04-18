const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const arr = (input[0].split(' ').map(Number)).sort((a, b) => a - b);
    const str = input[1];

    let ans = '';

    for (const s of str) {
        if (s === 'A') {
            ans = ans.concat(arr[0] + ' ');
        } else if (s === 'B'){ 
            ans = ans.concat(arr[1] + ' ');
        } else {
            ans = ans.concat(arr[2] + ' ');
        }
    }

    console.log(ans)
}

main();