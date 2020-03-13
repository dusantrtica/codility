const passingCarsBruteForce = (A) => {
    const n = A.length;
    let count = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            if (A[i] < A[j]) {
                count += 1;
                if (count > 1000000000) {
                    return -1;
                }
            }
        }
    }
    return count;
}

export default passingCarsBruteForce;