const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const yeondu = readLine();

  const N = +readLine();
  
  let L = 0;
  let O = 0;
  let V = 0;
  let E = 0;

  for (let c of yeondu) {
    if (c === 'L') L++;
    else if (c === 'O') O++;
    else if (c === 'V') V++;
    else if (c === 'E') E++;
  }

  let max = 0;
  let ans = '';

  for (let i = 0 ; i < N ; i++) {
    const name = readLine();
    
    let tL = L;
    let tO = O;
    let tV = V;
    let tE = E;

    for (let c of name) {
      if (c === 'L') tL++;
      else if (c === 'O') tO++;
      else if (c === 'V') tV++;
      else if (c === 'E') tE++;
    }
    let score = ((tL + tO) * (tL + tV) * (tL + tE) * (tO + tV) * (tO + tE) * (tV + tE)) % 100;

    if (max === score) {
      if (ans === '') ans = name;
      else if (ans > name) ans = name;
    } else if (max < score) {
      max = score;
      ans = name;
    }
  }

  console.log(ans)
}

main();