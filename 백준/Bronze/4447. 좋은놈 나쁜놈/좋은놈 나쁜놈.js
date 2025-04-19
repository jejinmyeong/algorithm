const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    let ans = '';

    for (let i = 1 ; i <= N ; i++) {
        const str = input[i];

        let g = 0;
        let b = 0;

        for (let s of str.toLowerCase()) {
            if (s === 'g') g++;
            else if (s === 'b') b++;
        }

        if (g < b) ans = ans.concat(str + ' is A BADDY\n');
        else if (g > b) ans = ans.concat(str + ' is GOOD\n');
        else ans = ans.concat(str + ' is NEUTRAL\n');
    }

    console.log(ans);
}

main();