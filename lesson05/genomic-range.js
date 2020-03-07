const genomicRangeBruteForce = (S, P, Q) => {
    const Snums = [...S].map(char => {
        switch (char) {
            case 'A': return 1;
            case 'C': return 2;
            case 'G': return 3;
            case 'T': return 4;
            default: throw new Error('Unsupported character');
        }
    });

    const result = P.map((p, index) => {
        const q = Q[index];
        let min = Snums[p];
        for (let i = p + 1; i <= q; i += 1) {
            if (Snums[i] < min) {
                min = Snums[i];
            }
        }
        return min;
    });
    return result;
}

export default genomicRangeBruteForce;