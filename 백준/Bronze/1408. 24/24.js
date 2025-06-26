const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let [ h1, m1, s1 ] = readLine().split(':').map(Number);
  let [ h2, m2, s2 ] = readLine().split(':').map(Number);

  let [ h3, m3, s3 ] = [ 0, 0, 0 ];
  if (s2 - s1 < 0) {
    m1++;
  }
  s3 = Math.abs((60 + s2 - s1) % 60);

  if (m2 - m1 < 0) {
    h1++;
  }
  m3 = Math.abs((60 + m2 - m1) % 60);

  h3 = Math.abs((24 + h2 - h1) % 24);

  console.log(`${h3.toString().padStart(2, '0')}:${m3.toString().padStart(2, '0')}:${s3.toString().padStart(2, '0')}`);
}

main();