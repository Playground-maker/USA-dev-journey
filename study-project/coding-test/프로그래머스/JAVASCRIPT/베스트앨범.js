function solution(genres, plays) {
    let data = {};
    let answer = [];

    genres.map((val, idx) => {
        if (!data[val]) {
            data[val] = { total: 0, songs: {} };
        }
        data[val].total += plays[idx];
        data[val].songs[idx] = plays[idx];
    });

    const sortedTitle = Object.entries(data)
        .sort(([, a], [, b]) => b.total - a.total)
        .map(([key]) => key);

    sortedTitle.map((val) => {
        let sortedSongs = Object.entries(data[val].songs);
        sortedSongs.sort((a, b) => b[1] - a[1]);

        if (sortedSongs.length >= 1) answer.push(Number(sortedSongs[0][0]));
        if (sortedSongs.length >= 2) answer.push(Number(sortedSongs[1][0]));
    });

    return answer;
}
