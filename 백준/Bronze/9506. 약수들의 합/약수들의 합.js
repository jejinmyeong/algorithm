const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
  const arr = [1];
  let sum = 1;

  for (let i = 2 ; i <= Math.sqrt(n) ; i++) {
    if (n % i !== 0) continue; 

    if (i * i === n) {
      arr.push(i);
      sum += i;
    } else {
      arr.push(i);
      arr.push(n / i);
      sum += i + n / i;
    }
  }
  
  if (n === sum) {
    return `${n} = ${arr.sort((a, b) => a - b).join(' + ')}`;
  } else {
    return `${n} is NOT perfect.`
  }
}

const main = () => {
  let ans = [];
  
  while (true) {
    const n = +readLine();

    if (n === -1) break;

    ans.push(solution(n));
  }

  console.log(ans.join('\n'));
}

main();
