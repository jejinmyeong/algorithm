const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const A = +readLine();
  const B = +readLine();
  const C = +readLine();

  console.log(A * B + C);
};

main();
