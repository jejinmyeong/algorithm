const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ A, B ] = readLine().split(' ');
  
  const sum = BigInt('0b' + A) + BigInt('0b' + B);

  console.log(sum.toString(2))
}

main();