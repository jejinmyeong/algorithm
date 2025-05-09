const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}


const solution = (s, t) => {
  if (s === t) {
    console.log(0)
    return;
  }

  const visited = Array(t + 1);
  visited[s] = true;

  const queue = [[ s, '' ]];
  let ans = '';

  while (queue.length !== 0) {
    const [ cur, ops ] = queue.shift();

    if (cur === t) {
      ans = ops;
      break;
    }

    for (let i = 0 ; i < 4 ; i++) {
      let next = cur;

      if (i === 0) next *= cur;
      else if (i === 1) next += cur;
      else if (i === 2) next -= cur;
      else if (i === 3) next /= cur;

      if (next > t || visited[next]) continue;

      visited[next] = true;
      if (i === 0) queue.push([ next, ops.concat('*') ]);
      else if (i === 1) queue.push([ next, ops.concat('+') ]);
      else if (i === 2) queue.push([ next, ops.concat('-') ]);
      else if (i === 3) queue.push([ next, ops.concat('/') ]);
    }
  }

  if (ans === '') {
    console.log(-1)
  } else {
    console.log(ans);
  }
}

const main = () => {
  const [ s, t ] = readLine().split(' ').map(Number); 
  
  solution(s, t);
}

main();
