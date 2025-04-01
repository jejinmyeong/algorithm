const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let ans = '';
    for (let i = 0 ; i < input.length ; i++) {
        if (input[i] === '#') break;

        let temp = 0;

        for (let j = 0 ; j < input[i].length ; j++) {
            if (input[i].charAt(j) === '-') temp += 0 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '\\') temp += 1 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '(') temp += 2 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '@') temp += 3 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '?') temp += 4 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '>') temp += 5 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '&') temp += 6 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '%') temp += 7 * Math.pow(8, input[i].length - j - 1);
            else if (input[i].charAt(j) === '/') temp += -1 * Math.pow(8, input[i].length - j - 1);
        }

        ans = ans.concat(temp + '\n');
    }

    console.log(ans);
}

main();