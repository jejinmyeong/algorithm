const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let point1 = 0;
    let point2 = 0;
    let point3 = 0;

    const Adrian = "ABC";
    const Bruno = "BABC";
    const Goran = "CCAABB"

    const N = parseInt(input[0]);
    const answer = input[1];

    for (let i = 0 ; i < N ; i++) {
        if (Adrian.charAt(i % 3) === answer.charAt(i)) point1++;
        if (Bruno.charAt(i % 4) === answer.charAt(i)) point2++;
        if (Goran.charAt(i % 6) === answer.charAt(i)) point3++
    }

    let max = Math.max(point1, point2, point3);

    let ans = max + '\n';

    if (point1 === max) ans = ans.concat("Adrian \n");
    if (point2 === max) ans = ans.concat("Bruno \n");
    if (point3 === max) ans = ans.concat("Goran \n");

    console.log(ans);
}

main();