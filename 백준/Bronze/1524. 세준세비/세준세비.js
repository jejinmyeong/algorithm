const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const T = +readLine();

  const res = Array(T).fill(null).map(() => {
    readLine();
    const [ N, M ] = readLine().split(' ').map(Number);

    const sejun = Math.max(...readLine().split(' ').map(Number));
    const sebi = Math.max(...readLine().split(' ').map(Number));

    return sejun >= sebi ? 'S' : 'B'
  })

  console.log(res.join('\n'))
}

main();