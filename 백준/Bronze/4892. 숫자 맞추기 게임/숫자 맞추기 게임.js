const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let t = 0;
    let ans = '';
    while (true) {
        const N0 = parseInt(input[t++]);

        if (N0 === 0) break;

        const N1 = N0 * 3;
        let N2 = 0;
        
        ans = ans.concat(t);
        if (N1 % 2 === 0) {
            ans = ans.concat('. even ');
            N2 = N1 / 2;
        } else {
            ans = ans.concat('. odd ');
            N2 = (N1 + 1) / 2;
        }

        const N3 = 3 * N2;
        const N4 = parseInt(N3 / 9);

        ans = ans.concat(N4 + '\n');
    }

    console.log(ans);
}

main();