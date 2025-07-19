const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  let sum = 300;
  for (let i = 0; i < 4; i++) {
    sum += +readLine();
  }

  console.log(sum > 1800 ? "No" : "Yes");
};

main();
