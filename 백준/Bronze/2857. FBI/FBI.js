const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let ans = '';

    for (let i = 0 ; i < 5 ; i++) {
        if (input[i].includes('FBI')) {
            ans = ans.concat((i + 1) + ' ');
        }
    }

    if (ans === '') console.log('HE GOT AWAY!');
    else console.log(ans);
}

main();