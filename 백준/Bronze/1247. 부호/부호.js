const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const ans = Array.from({ length: 3 }).map(() => {
    const N = +readLine();

    let sum = 0n;

    for (let i = 0 ; i < N ; i++) {
      sum += BigInt(readLine());
    }
  
    if (sum > 0) return '+';
    else if (sum < 0) return '-';
    else return 0;
  })

  console.log(ans.join('\n'))
}

main();