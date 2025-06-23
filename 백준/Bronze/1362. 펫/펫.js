const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  
  let ans = [];
  
  while (true) {
    const [ o, w ] = readLine().split(' ').map(Number);
    
    if (o === 0 && w === 0) break;
    
    let now = w;

    while (true) {
      const line = readLine();
  
      if (line === '# 0') {
        if (now <= 0) {
          ans.push('RIP');
        } else if (2 * now > o && now < o * 2) {
          ans.push(':-)')
        } else {
          ans.push(':-(')
        }
  
        break;
      }
  
      const [ c, n ] = line.split(' ');
  
      if (now <= 0) continue;
  
      if (c === 'F') {
        now += parseInt(n);
      } else if (c === 'E') {
        now -= parseInt(n);
      }
    }
  }

  console.log(ans.map((v, idx) => `${idx + 1} ${v}`).join('\n'));
}

main();
