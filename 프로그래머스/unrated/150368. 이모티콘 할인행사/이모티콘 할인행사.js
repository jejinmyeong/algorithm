let _users;
let _emoticons;
let N, M;
let pays;

let newUser;
let price;

function solution(users, emoticons) {
    var answer = [];
    
    N = users.length;
    M = emoticons.length;
    _users = users;
    _emoticons = emoticons;
    
    pays = new Array(4).fill(0);
    // 1~10 11~20 21~30 31~40
    
    newUser = 0;
    price = 0;
    dfs(0)
    
    answer = [newUser, price];
    
    return answer;
}

function dfs (cnt) {
    if (cnt === M) {
        let cnt = 0;
        let temp = 0;
        for (let i = 0 ; i < N ; i++) {
            let userIndex = _users[i][0] > 30 ? 3 : _users[i][0] > 20 ? 2 : _users[i][0] > 10 ? 1 : 0;
            if (pays[userIndex] < _users[i][1]) {
                temp += pays[userIndex];
            } else {
                cnt++;
            }
        }
        if (cnt > newUser) {
            newUser = cnt;
            price = temp;
        } else if (cnt === newUser) {
            price = Math.max(price, temp);
        }
        return;
    }
    
    for (let i = 1 ; i <= 4 ; i++) {
        let pay = _emoticons[cnt] - _emoticons[cnt] * i / 10;
        
        for (let j = 0 ; j < i ; j++) {
            pays[j] += pay;
        }
        
        dfs(cnt + 1);
        
        for (let j = 0 ; j < i ; j++) {
            pays[j] -= pay;
        }
    }
}