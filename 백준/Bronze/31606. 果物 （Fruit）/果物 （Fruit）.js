const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const X = +readLine();
  const Y = +readLine();

  console.log(X + Y + 3);
};

main();
