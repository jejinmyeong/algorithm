const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    let N = parseInt(input[0]);

    if (N === 1) console.log(2024, 8);
    else if (N === 2) console.log(2025, 3);
    else if (N === 3) console.log(2025, 10);
    else if (N === 4) console.log(2026, 5);
    else if (N === 5) console.log(2026, 12);
}

main();