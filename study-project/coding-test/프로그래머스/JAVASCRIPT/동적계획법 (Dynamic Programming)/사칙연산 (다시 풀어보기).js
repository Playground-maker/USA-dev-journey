function solution(arr) {
    let TotalSum = [0, 0];
    let pivot = arr.length - 1;
    let sum = 0;

    while (pivot >= 0) {
        if (!isNaN(arr[pivot][0])) {
            sum += parseInt(arr[pivot]);
        } else if (arr[pivot][0] === "-") {
            let TempSum = [...TotalSum];

            TotalSum[0] = Math.min(-(TempSum[1] + sum), TempSum[0] - sum);
            TotalSum[1] = Math.max(-(TempSum[0] + sum), TempSum[1] + sum - 2 * parseInt(arr[pivot + 1]));
            sum = 0;
        }

        pivot--;
    }

    TotalSum[1] += sum;
    return TotalSum[1];
}
