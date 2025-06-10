const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const gcd = (a, b) => {
  if (b <= 0) return a;

  return gcd(b, a % b);
}

const main = () => {
  const arr = readLine().split(' ').map(Number);

  let min = Infinity;

  for (let i = 0 ; i < 3 ; i++) {
    for (let j = i + 1 ; j < 4 ; j++) {
      let gcd1 = gcd(arr[i], arr[j]);
      const temp = (arr[i] / gcd1) * (arr[j] / gcd1) * gcd1;
      for (let k = j + 1 ; k < 5 ; k++) {
        let gcd2 = gcd(temp, arr[k]);

        min = Math.min(min, (temp / gcd2) * (arr[k] / gcd2) * gcd2);
      }
    }
  }

  console.log(min);
}

main();