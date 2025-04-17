const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const [ R, C, ZR, ZC ] = input[0].split(' ').map(Number);

    let ans = '';

    for (let i = 1 ; i <= R ; i++) {
        for (let k = 0 ; k < ZR ; k++) {
            for (let j = 0 ; j < C ; j++) { 
                for (let l = 0 ;l < ZC ; l++) {
                    ans = ans.concat(input[i].charAt(j));
                }
            }
            ans = ans.concat('\n');
        }
    }

    console.log(ans);
}

main();