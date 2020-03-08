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

const genomicRangeV1 = (S, P, Q) => {
    const genomMapping = { 1: [], 2: [], 3: [], 4: [] };
    const Snums = [...S].map((char, index) => {
        switch (char) {
            case 'A': genomMapping[1].push(index); return 1;
            case 'C': genomMapping[2].push(index); return 2;
            case 'G': genomMapping[3].push(index); return 3;
            case 'T': genomMapping[4].push(index); return 4;
            default: throw new Error('Unsupported character');
        }
    });

    const result = P.map((p, index) => {
        const q = Q[index];
        if (genomMapping[1].some(val => p <= val && val <= q)) {
            return 1;
        }
        if (genomMapping[2].some(val => p <= val && val <= q)) {
            return 2;
        }
        if (genomMapping[3].some(val => p <= val && val <= q)) {
            return 3;
        }
        return 4;
    });

    return result;
}

export default genomicRangeV1;