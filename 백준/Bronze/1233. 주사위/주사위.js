const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ s1, s2, s3 ] = readLine().split(' ').map(Number);

  const arr = Array(s1 + s2 + s3 + 1).fill(0);

  for (let i = 1 ; i <= s1 ; i++) {
    for (let j = 1 ; j <= s2 ; j++) {
      for (let k = 1 ; k <= s3 ; k++) {
        arr[i + j + k]++;
      }
    }
  }

  const max = Math.max(...arr);
  
  let ans = -1;

  for (let i = 3 ; i <= s1 + s2 + s3 ; i++) {
    if (arr[i] === max) {
      ans = i;
      break;
    }
  }

  console.log(ans)
}

main();