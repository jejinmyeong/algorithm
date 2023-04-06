function solution(data, col, row_begin, row_end) {
    var answer = 0;
    data.sort((a, b) => {
        if (a[col - 1] === b[col - 1]) return b[0] - a[0];
        return a[col - 1] - b[col - 1];
    })
    
    let S_i = [];
    
    for (let i = row_begin - 1 ; i < row_end ; i++) {
        S_i.push(0);
        for (let j = 0 ; j < data[i].length ; j++) {
            S_i[i - row_begin + 1] += data[i][j] % (i+1);
        }
    }
    
    let XOR = S_i[0].toString(2);
    
    for (let i = 1 ; i < S_i.length ; i++) {
        let now = S_i[i].toString(2);
        while (XOR.length > now.length) {
            now = "0" + now;
        }
        
        while (XOR.length < now.length) {
            XOR = "0" + XOR;
        }
        let temp = "";
        for (let i = 0 ; i < now.length ; i++) {
            if (XOR[i] !== now[i]) temp += "1";
            else temp += "0";
        }
        
        XOR = temp;
    }
    
    answer = parseInt(XOR, 2);
    return answer;
}