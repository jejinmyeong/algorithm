function solution(n, m, section) {
  var answer = 0;
  
  let visited = new Array(n).fill(true);
  
  for (let i = 0 ; i < section.length ; i++) {
      visited[section[i] - 1] = false;
  }
  
  for (let i = 0 ; i < n ; i++) {
      if (visited[i]) continue;
      answer++;
      for (let j = 0 ; j < m ; j++) {
          visited[i + j] = true;
      }
  }
  return answer;
}