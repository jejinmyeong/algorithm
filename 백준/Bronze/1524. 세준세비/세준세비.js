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

    const sejun = readLine().split(' ').map(Number).sort((a, b) => b - a);
    const sebi = readLine().split(' ').map(Number).sort((a, b) => b - a);

    return sejun[0] >= sebi[0] ? 'S' : 'B'
  })

  console.log(res.join('\n'))
}

main();