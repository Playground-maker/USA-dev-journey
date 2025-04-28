function solution(n, wires) {
    let answer = n;

    const createGraph = (wires) => {
        const graph = Array.from({ length: n + 1 }, () => []);
        wires.forEach(([start, end]) => {
            graph[start].push(end);
            graph[end].push(start);
        });
        return graph;
    };

    const bfs = (first, graph, visited) => {
        let count = 0;
        const queue = [first];
        visited[first] = true;

        while (queue.length > 0) {
            const node = queue.shift();
            count++;

            for (const next of graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.push(next);
                }
            }
        }
        return count;
    };

    for (let i = 0; i < wires.length; i++) {
        const disconnectedWires = wires.slice(0, i).concat(wires.slice(i + 1));
        const graph = createGraph(disconnectedWires);

        const visited = Array(n + 1).fill(false);
        const total1 = bfs(1, graph, visited);
        const total2 = n - total1;

        let difference = 0;

        if (total1 > total2) difference = total1 - total2;
        else difference = total2 - total1;

        if (difference < answer) answer = difference;
    }

    return answer;
}
