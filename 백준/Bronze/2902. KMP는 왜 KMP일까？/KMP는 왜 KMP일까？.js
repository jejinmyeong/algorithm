const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const name = readLine().split('-');

  console.log(name.map((s) => s[0]).join(''));
}

main();
