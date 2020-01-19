const maxCounters = (N, A) => {
    const result = {};
    const n = A.length;
    for (var i = 0; i < n; i++) {
        const curr = A[i];
        if (1 <= curr && curr <= N) {
            result[curr] = (result[curr] || 0) + 1;
        }
    }

    const outcome = [];
    for (var i = 1; i <= N; i++) {
        outcome.push(result[i] || 0);
    }
    return outcome;
}

export default maxCounters;