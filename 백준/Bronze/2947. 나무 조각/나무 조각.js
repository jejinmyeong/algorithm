const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const arr = input[0].split(' ').map(Number);
    let ans = '';

    while (true) {
        for (let i = 0 ; i < 4 ; i++) {
            if (arr[i] > arr[i + 1]) {
                let temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                ans = ans.concat(arr.join(' ') + '\n');
            }
        }

        let flag = true;

        for (let i = 0 ; i < 4 ; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = false;
                break;
            }
        }

        if (flag) break;
    }

    console.log(ans);
}

main();