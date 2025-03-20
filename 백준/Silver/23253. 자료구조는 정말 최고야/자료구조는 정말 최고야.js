var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');

function isDescending(arr) {
    return arr.every((v, i) => i === 0 || v <= arr[i - 1]);
}

function main() {
    let [n, k] = input[0];

    for (let i = 2 ; i < input.length ; i += 2) {
        if (!isDescending(input[i].split(' ').map(Number))) {
            console.log('No');
            
            return;
        }
    }

    console.log('Yes');
    
    return;
}

main();