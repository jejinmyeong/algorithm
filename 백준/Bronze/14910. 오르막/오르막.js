const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const arr = input[0].split(' ').map(Number);

    for (let i = 1 ; i < arr.length ; i++) {
        if (arr[i] < arr[i - 1]) {
            console.log('Bad');
            return;
        }
    }

    console.log('Good');
    return;
}

main();