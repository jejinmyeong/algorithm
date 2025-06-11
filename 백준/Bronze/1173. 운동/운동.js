const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, m, M, T, R ] = readLine().split(' ').map(Number);

  let ans = 0;
  let cnt = 0;
  let now = m;

  if ((M - m) < T) {
    console.log(-1)
    return;
  }
  
  while (true) {
    if (now + T > M) {
      now -= R;;

      if (now < m) now = m;
      ans++;

      continue;
    }

    now += T;
    ans++;
    cnt++;

    if (cnt === N) break;
  }

  console.log(ans);
}

main();