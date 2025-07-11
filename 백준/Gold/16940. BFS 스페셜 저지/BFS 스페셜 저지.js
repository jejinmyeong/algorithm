const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

class Queue {
  #arr;
  #idx;

  constructor() {
    this.#arr = [];
    this.#idx = 0;
  }

  push(value) {
    this.#arr.push(value);
  }

  pop() {
    if (this.isEmpty()) {
      throw new Error('queue is Empty');
    }

    const value = this.#arr[this.#idx];
    this.#idx++;

    return value;
  }

  peek() {
    if (this.isEmpty()) {
      throw new Error('queue is Empty');
    }

    return this.#arr[this.#idx];
  }

  isEmpty() {
    return this.#arr.length - this.#idx === 0;
  }

  size() {
    return this.#arr.length - this.#idx;
  }

}

const main = () => {
  const N = +readLine();
  const nodes = Array.from({ length: N + 1 }, () => []);

  for (let i = 0 ; i < N - 1 ; i++) {
    const [ s, e ] = readLine().split(' ').map(Number);

    nodes[s].push(e);
    nodes[e].push(s);
  }

  const arr = readLine().split(' ').map(Number);

  const visited = Array(N + 1).fill(false);

  const start = arr[0];

  if (start !== 1) {
    console.log(0);
    return;
  }

  const queue = new Queue();
  queue.push(start);
  visited[start] = true;

  const temp = new Set();
  let idx = 1;

  while (!queue.isEmpty()) {
    const cur = queue.pop();

    for (const n of nodes[cur]) {
      if (visited[n]) continue;

      visited[n] = true;
      temp.add(n);
    }

    for (let i = idx ; i < idx + temp.size ; i++) {
      let num = arr[i];
      if (temp.has(num)) queue.push(num);
      else {
        console.log(0);
        return;
      }
    }

    idx += temp.size;
    temp.clear();
  }

  if (idx === N) {
    console.log(1);
  } else {
    console.log(0);
  }
}


main();