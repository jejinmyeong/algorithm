const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

class Node {
    constructor(x, y, cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

const [ N, M ] = input[0].split(' ').map(Number);
const map = [];
let max = 0, ans = 0;

function main () {

    for (let i = 1 ; i <= N ; i++) {
        const line = input[i].split(' ').map(Number);

        map[i - 1] = [];

        for (let j = 0 ; j < M ; j++) {
            map[i - 1].push(line[j]);
        }
    }

    for (let i = 0 ; i < N ; i++) {
        for (let j = 0 ; j < M ; j++) {
            if (map[i][j] === 0) continue;

            bfs(i, j, map[i][j]);
        }
    }

    console.log(ans)
}

const D = [[ -1, 0 ], [ 0, 1 ], [ 1, 0 ], [ 0, -1 ]];

function bfs (x, y, num) {
    const visited = Array.from({ length: N }, () => Array(M).fill(false));

    const queue = [];
    queue.push(new Node(x, y, 1));
    visited[x][y] = true;

    while (queue.length !== 0) {
        const now = queue.shift();

        for (let d = 0 ; d < 4 ; d++) {
            const nx = now.x + D[d][0];
            const ny = now.y + D[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] === 0 || visited[nx][ny]) continue;

            if (max < now.cnt + 1) {
                max = now.cnt + 1;
                ans = num + map[nx][ny];
            } else if (max === now.cnt + 1) ans = Math.max(ans, num + map[nx][ny]);

            visited[nx][ny] = true;
            queue.push(new Node(nx, ny, now.cnt + 1));
        }
    }
}

main();