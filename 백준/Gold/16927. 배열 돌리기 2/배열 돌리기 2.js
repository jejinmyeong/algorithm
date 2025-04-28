const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const [ N, M, R ] = input[0].split(' ').map(Number);

    const arr = Array.from({ length: N }, () => Array(M).fill(0));
    const res = Array.from({ length: N }, () => Array(M).fill(0));

    for (let i = 1 ; i <= N ; i++) {
        const line = input[i].split(' ').map(Number);
        for (let j = 0 ; j < M ; j++) {
            arr[i - 1][j] = line[j];
        }
    }

    const D = [ [ 0, 1 ], [ 1, 0 ], [ 0, -1 ], [ -1, 0 ]];
    
    for (let i = 0 ; i < Math.min(N, M) / 2 ; i++) {
        // 회전 시키는 배열의 개수
        const C = 2 * N + 2 * M - 2 * i * 4 - 4;
        const r = R % C;

        let x = i;
        let y = i;

        let d = 0;
        // 처음 0, 0에 삽입할 위치 찾기
        for (let j = 1 ; j < r ; j++) {
            // 배열의 범위에서 벗어나면 방향을 바꿈
            if (x + D[d][0] < i || y + D[d][1] < i || x + D[d][0] >= N - i || y + D[d][1] >= M - i) d = (d + 1) % 4;

            x = x + D[d][0];
            y = y + D[d][1];    
        }
        
        let nx = i;
        let ny = i;
        
        if (r !== 0) {
            if (x + D[d][0] < i || y + D[d][1] < i || x + D[d][0] >= N - i || y + D[d][1] >= M - i) d = (d + 1) % 4;
            
            nx = x + D[d][0];
            ny = y + D[d][1];
        }
        
        x = i;
        y = i;

        res[x][y] = arr[nx][ny];

        let dd = 0;

        for (let j = 1 ; j < C ; j++) {

            if (nx + D[d][0] < i || ny + D[d][1] < i || nx + D[d][0] >= N - i || ny + D[d][1] >= M - i) d = (d + 1) % 4;

            nx = nx + D[d][0];
            ny = ny + D[d][1];

            if (x + D[dd][0] < i || y + D[dd][1] < i || x + D[dd][0] >= N - i || y + D[dd][1] >= M - i) dd = (dd + 1) % 4;

            x = x + D[dd][0];
            y = y + D[dd][1];

            res[x][y] = arr[nx][ny];
        }

    }
    let ans = '';

    for (let j = 0 ; j < N ; j++) {
        ans = ans.concat(res[j].join(' ') + '\n');
    }

    console.log(ans);
}

main();