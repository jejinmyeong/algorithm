const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let ans = '';

    for (let i = 0 ; i < input.length ; i++) {
        const [ w, ...arr ] = input[i].split(' ');

        if (w === '#') break;

        let cnt = 0;

        for (let s of arr) {
            for (let j = 0 ; j < s.length ; j++) {
                if (s.charAt(j).toLowerCase() === w) cnt++;
            }
        }

        ans = ans.concat(w + ' ' +  cnt + '\n');
    }

    console.log(ans)
}

main();