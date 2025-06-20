const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  const files = readLine().split(' ').map(Number);
  const size = +readLine();

  let cnt = 0;

  for (let i = 0 ; i < N ; i++) {
    cnt += Math.ceil(files[i] / size);
  }
  
  console.log(cnt * size);
}

main();
