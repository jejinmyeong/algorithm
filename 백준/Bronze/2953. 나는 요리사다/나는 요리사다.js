const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let winner = 0;
    let point = 0;

    for (let i = 0 ; i < 5 ; i++) {
        const points = input[i].split(' ').map(Number);

        let sum = 0;

        for (let p of points) sum += p;

        if (sum > point) {
            winner = i + 1;
            point = sum;
        }
    }

    console.log(winner, point)
}

main();