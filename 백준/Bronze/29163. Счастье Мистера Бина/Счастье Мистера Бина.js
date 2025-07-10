const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  const arr = readLine().split(' ').map(Number);

  console.log(arr.filter((a) => a % 2 === 0).length > N / 2 ? "Happy" : "Sad")
}


main();