const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n, m, DNA, marker) => {
  const mutations = new Set();
  for (let i = 0 ; i < m ; i++) {
    for (let j = i + 1 ; j <= m ; j++){
      mutations.add(marker.slice(0, i) + marker.slice(i, j).split('').reverse().join('') + marker.slice(j))
    }
  }

  let cnt = 0;
  for (let i = 0 ; i < n - m + 1 ; i++) {
    const temp = DNA.slice(i, i + m);
    
    if (mutations.has(temp)) cnt++;
  }

  return cnt;
}

const main = () => {
  const t = +readLine();

  const res = Array.from({ length: t }).map((_) => {
    const [ n, m ] = readLine().split(' ').map(Number);

    return solution(n, m, readLine(), readLine());
  });

  console.log(res.join('\n'));
}

main();
