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

    while (sejun.length + sebi.length !== 1) {
      if (sejun.length === 0) {
        sebi.pop();
        continue;
      }

      if (sebi.length === 0) {
        sejun.pop();
        continue;
      }

      if (sejun.at(-1) >= sebi.at(-1)) sebi.pop();
      else sejun.pop();
    }

    if (sejun.length > sebi.length) return 'S';
    else return 'B';
  })

  console.log(res.join('\n'))
}

main();