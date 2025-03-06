function solution(tickets) {
    tickets.sort();
    let result = [];
    let visited = Array(tickets.length).fill(false);

    function dfs(airport, visited) {
        if (airport.length === tickets.length + 1) {
            result.push(airport);
            return true;
        } else {
            for (let i = 0; i < tickets.length; i++) {
                let [from, to] = tickets[i];
                if (visited[i] === false && airport[airport.length - 1] === from) {
                    visited[i] = true;
                    airport.push(to);

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
