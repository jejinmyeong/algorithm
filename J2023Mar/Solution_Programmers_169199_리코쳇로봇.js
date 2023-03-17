let N = null;
let M = null;
let map = null;

function solution(board) {
    N = board.length;
    M = board[0].length;
    
    let start = {x : null,y : null};
    
    map = new Array(N + 2);
    for (let i = 0 ; i < N + 2 ; i++) {
        map[i] = new Array(M + 2).fill('D');
    }
    
    for (let i = 0 ; i < N ; i++) {
        for (let j = 0 ; j < M ; j++) {
            let c = board[i][j];
            if (c === 'R') {
                start.x = i + 1;
                start.y = j + 1;
            }
            map[i + 1][j + 1] = c;
        }
    }
    
    return bfs(start);
}

function bfs(start) {
    let visited = new Array(N + 2);
    for (let i = 0 ; i < N + 2 ; i++) {
        visited[i] = new Array(M + 2).fill(false);
    }
    
    let queue = [];
    queue.push({x: start.x, y: start.y, c: 0});
    visited[start.x][start.y] = true;
    
    const D = [[-1, 0],[0, 1],[1, 0],[0, -1]];
    
    while(queue.length !== 0) {
        let now = queue.shift();

        if (map[now.x][now.y] === 'G') {
            return now.c;
        }

        for (let d = 0 ; d < 4 ; d++) {
            let nx = now.x;
            let ny = now.y;

            while (map[nx][ny] !== 'D') {
                nx += D[d][0];
                ny += D[d][1];
            }

            nx -= D[d][0];
            ny -= D[d][1];

            if (visited[nx][ny]) continue;

            console.log(visited[nx][ny]);
            visited[nx][ny] = true;
            queue.push({x: nx, y: ny, c: now.c + 1});
        }
        
    }
    
    return -1;
    
}