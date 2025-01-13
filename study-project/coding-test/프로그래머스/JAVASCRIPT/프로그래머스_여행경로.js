function solution(tickets) {
    tickets.sort(); // 티켓 정렬
    let result = [];
    let visited = Array(tickets.length).fill(false);

    function dfs(airport, visited) {
        if (airport.length === tickets.length + 1) {
            result.push(airport);
            return true;
        } else {
            // DFS 재귀 반복문
            for (let i = 0; i < tickets.length; i++) {
                let [from, to] = tickets[i];
                if (visited[i] === false && airport[airport.length - 1] === from) {
                    // 이전 도착지랑 출발지가 같으면 값 추가
                    // visited 배열도 고려
                    visited[i] = true;
                    airport.push(to);

                    // 재귀해서 반환값으로 백트래킹 유무
                    if (dfs(airport, visited)) {
                        return true;
                    }

                    visited[i] = false;
                    airport.pop();
                }
            }
        }
        return false;
    }

    dfs(["ICN"], visited);
    return result[0];
}
