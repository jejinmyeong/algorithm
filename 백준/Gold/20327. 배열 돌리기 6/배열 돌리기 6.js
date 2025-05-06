const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let size = 0;
let arr = new Array;
let len
const main = () => {
  const [ N, R ] = input[0].split(' ').map(Number);
  
  size = Math.pow(2, N);
  arr = Array.from({ length: size}, () => Array(size).fill(0));
  
  for (let i = 0 ; i < Math.pow(2, N) ; i++) {
    const line = input[i + 1].split(' ').map(Number);
  
    for (let j = 0 ; j < Math.pow(2, N) ; j++) {
      arr[i][j] = line[j];
    }
  }

  for (let i = 0 ; i < R ; i++) {
    const [ k, l ] = input[Math.pow(2, N) + 1 + i].split(' ').map(Number);

    if (k === 1) cal1(l);
    else if (k === 2) cal2(l);
    else if (k === 3) cal3(l);
    else if (k === 4) cal4(l);
    else if (k === 5) cal5(l);
    else if (k === 6) cal6(l);
    else if (k === 7) cal7(l);
    else if (k === 8) cal8(l);
  }

  printArray();
}

const cal1 = (l) => {
  const len = Math.pow(2, l);
  for (let i = len ; i <= size ; i += len) {
    let cnt = 0;
    for (let j = i - len ; j < i - len / 2 ; j++) {
      cnt++;
      for (let k = 0 ; k < size ; k++) {
        const temp = arr[j][k];

        arr[j][k] = arr[i - cnt][k];
        arr[i - cnt][k] = temp;
      }
    }
  }
}

const cal2 = (l) => {
  const len = Math.pow(2, l)
  for (let i = len ; i <= size ; i += len) {
    let cnt = 0;
    for (let j = i - len ; j < i - len / 2 ; j++) {
      cnt++;
      for (let k = 0 ; k < size ; k++) {
        const temp = arr[k][j];

        arr[k][j] = arr[k][i - cnt];
        arr[k][i - cnt] = temp;
      }
    }
  }
}

const cal3= (l) => {
  const len = Math.pow(2, l);
  const temp = Array.from({ length: size }, () => Array(size).fill(0));

  for (let i = 0 ; i < size ; i++) {
    for (let j = 0 ; j < size ; j++) {
      temp[parseInt(i / len) * len + j % len][(parseInt(j / len) + 1) * len - 1 - i % len] = arr[i][j];
    }
  }

  arr = temp;
}

const cal4 = (l) => {
  const len = Math.pow(2, l);
  const temp = Array.from({ length: size }, () => Array(size).fill(0));

  for (let i = 0 ; i < size ; i++) {
    for (let j = 0 ; j < size ; j++) {
      temp[(parseInt(i / len) + 1) * len - 1 - j % len][parseInt(j / len) * len + i % len] = arr[i][j];
    }
  }

  arr = temp;
}

const cal5 = (l) => {
  const len = Math.pow(2, l);

  for (let i = 0 ; i < size / 2 ; i++) {
    const row = parseInt((size - i - 1) / len) * len + i % len;
    for (let j = 0 ; j < size ; j++) {
      const temp = arr[i][j];

      arr[i][j] = arr[row][j];
      arr[row][j] = temp;
    }
  }
}

const cal6 = (l) => {
  const len = Math.pow(2, l);

  for (let i = 0 ; i < size / 2 ; i++) {
    const col = parseInt((size - i - 1) / len) * len + i % len;
    for (let j = 0 ; j < size ; j++) {
      const temp = arr[j][i];

      arr[j][i] = arr[j][col];
      arr[j][col] = temp;
    }
  }
}

const cal7 = (l) => {
  const len = Math.pow(2, l);
  const temp = Array.from({ length: size }, () => Array(size).fill(0));

  for (let i = 0 ; i < size ; i++) {
    for (let j = 0 ; j < size ; j++) {
      temp[parseInt(j / len) * len + i % len][parseInt((size - 1 - i) / len) * len + j % len] = arr[i][j];
    }
  }
  arr = temp;
}

const cal8 = (l) => {
  const len = Math.pow(2, l);
  const temp = Array.from({ length: size }, () => Array(size).fill(0));

  for (let i = 0 ; i < size ; i++) {
    for (let j = 0 ; j < size ; j++) {
      temp[parseInt((size - 1 - j) / len) * len + i % len][parseInt(i / len) * len + j % len] = arr[i][j];
    }
  }
  arr = temp;
}

const printArray = () => {
  let ans = '';
  for (let i = 0 ; i < size ; i++) {
    ans = ans.concat(arr[i].join(' ') + '\n');
  }

  console.log(ans);
}

main();
