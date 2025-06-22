const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ X, Y ] = readLine().split(' ');

  console.log(parseInt((parseInt(X.split('').reverse().join('')) + parseInt(Y.split('').reverse().join(''))).toString().split('').reverse().join('')));
}

main();
