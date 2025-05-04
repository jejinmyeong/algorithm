const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main() {
  const N = parseInt(input[0]);

  let ans = '';

  for (let i = 1 ; i <= N ; i++) {
    ans = ans.concat(i + ' ');
    if (i % 6 === 0) ans = ans.concat('Go! ');
  }

  if (N % 6 !== 0) ans = ans.concat('Go!')

  console.log(ans);
}

main();