const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let set = new Set();

    for (let c of 'CAMBRIDGE') set.add(c);

    let ans = '';

    for (let c  of input[0]) {
        if (set.has(c)) continue;
        ans = ans.concat(c);
    }

    console.log(ans);
}

main();