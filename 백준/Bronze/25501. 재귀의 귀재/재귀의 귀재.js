const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const recursion = (s, l, r, cnt) => {
  if (l >= r) return [ 1, cnt ];
  else if (s[l] !== s[r]) return [ 0, cnt ];
  else return recursion(s, l + 1, r - 1, cnt + 1);
}

const isPalindrome = (s) => {
  return recursion(s, 0, s.length - 1, 1);
}

const main = () => {
  const T = +readLine();

  const res = Array.from({ length: T }).map(() => {
    const s = readLine();

    return isPalindrome(s).join(' ');
  });

  console.log(res.join('\n'));
}

main();