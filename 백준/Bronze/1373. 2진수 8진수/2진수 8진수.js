const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let binary = readLine();

  if (binary.length % 3 !== 0) {
    binary = binary.padStart(binary.length + 3 - binary.length % 3, '0');
  }

  let ans = '';

  for (let i = 0 ; i < binary.length ; i += 3) {
    const temp = binary.slice(i, i + 3);

    ans += parseInt(temp, 2).toString(8);
  }

  console.log(ans)
}

main();
