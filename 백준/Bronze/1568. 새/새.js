const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let N = parseInt(input[0]);

    let i = 1, ans = 0;

    while (N > 0) {
        if (N < i) i = 1;
        N -= i;
        ans++;
        i++;
    }

    console.log(ans);

}

main();