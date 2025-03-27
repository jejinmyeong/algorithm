const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);

    const map = new Map();

    for (let i = 1 ; i <= N ; i++) {
        const [ a, b, c ] = input[i].split(' ').map(Number);

        if (map.has(a) || map.has(b) || map.has(c)) {
            console.log(1);
            return;
        }
            
        map.set(a, 1); 
        map.set(b, 1);
        map.set(c, 1);
    }

    console.log(0)
}

main();