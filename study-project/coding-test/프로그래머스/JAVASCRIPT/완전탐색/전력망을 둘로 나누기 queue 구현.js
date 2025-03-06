function solution(n, wires) {
    let answer = n;

    class Queue {
        constructor() {
            this.queue = [];
            this.front = 0;
            this.rear = 0;
        }

        enqueue(value) {
            this.queue[this.rear++] = value;
        }

        dequeue() {
            const value = this.queue[this.front];
            delete this.queue[this.front];
            this.front++;
            return value;
        }

        length() {
            return this.rear - this.front;
        }
    }

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
        const qu = new Queue();
        qu.enqueue(first);
        visited[first] = true;

        while (qu.length() > 0) {
            const node = qu.dequeue();
            count++;

            for (const next of graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    qu.enqueue(next);
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

console.log(
    solution(9, [
        [1, 3],
        [2, 3],
        [3, 4],
        [4, 5],
        [4, 6],
        [4, 7],
        [7, 8],
        [7, 9],
    ])
);
