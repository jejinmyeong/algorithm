const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const n = +readLine();
  
  console.log("V".repeat(Math.floor(n / 5)) + "I".repeat(n % 5))
}

main();