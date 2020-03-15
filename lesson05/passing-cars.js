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

const passingCars = (A) => {
    const n = A.length;
    const zeroOccurences = [];
    let zeroCounter = 0;
    let passingCarsCount = 0;
    if (n === 1 || n === 0) {
        return 0;
    }
    for (let i = 0; i < n; i++) {
        if (A[i] === 0) {
            zeroCounter += 1;
        }
        zeroOccurences.push(zeroCounter);
    }
    for (let i = 0; i < n; i++) {
        if (A[i] === 1) {
            passingCarsCount += i > 0 ? zeroOccurences[i - 1] : 0;
            if (passingCarsCount > 1000000000) {
                return - 1;
            }
        }
    }

    return passingCarsCount;
}

export default passingCars;