const maxCounters = (N, A) => {
    const result = [];
    var maxCounter = 0;
    var lastResetValue = 0;
    for (var i = 0; i < N; i++) {
        result[i] = 0;
    }
    const n = A.length;
    for (var i = 0; i < n; i++) {
        const curr = A[i];
        if (curr <= N) {
            if (result[curr - 1] < lastResetValue) {
                result[curr - 1] = lastResetValue;
            }
            result[curr - 1] += 1;

            if (result[curr - 1] > maxCounter) {
                maxCounter = result[curr - 1];
            }
        } else {
            lastResetValue = maxCounter;
        }
    }

    for (var i = 0; i < N; i++) {
        if (result[i] < lastResetValue) {
            result[i] = lastResetValue;
        }
    }

    return result;
}

export default maxCounters;