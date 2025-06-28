const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ h, m, s ] = readLine().split(':').map(Number).sort((a, b) => a - b);

  if (h > 59 || m > 59 || s > 59) {
    console.log(0)
    return;
  }
  
  let hour = 0;

  if (h <= 12 && h >= 1) hour++;
  if (m <= 12 && m >= 1) hour++;
  if (s <= 12 && s >= 1) hour++;

  if (hour === 0) console.log(0);
  else if (hour === 1) console.log(2);
  else if (hour === 2) console.log(4);
  else console.log(6);
}

main();