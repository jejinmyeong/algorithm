const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main () {
    const N = parseInt(input[0]);

    let ans = 0;

    for (let i = 1 ; i <= N ; i++) {
        const [students, apples] = input[i].split(' ').map(Number);

        ans += apples % students;
    }
    
    console.log(ans);
}

main();