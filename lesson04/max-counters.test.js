import maxCounters from './max-counters';

describe('max-counters', () => {
    it('case 1: counter, one operation', () => {
        const N = 1;
        const A = [1];
        const result = maxCounters(N, A);
        expect(result).toEqual([1]);
    });

    it('case 2 ', () => {
        const N = 1;
        const A = [1, 1];
        const result = maxCounters(N, A);
        expect(result).toEqual([2]);
    });

    it('case 3: 2 counters', () => {
        const N = 2;
        const A = [1, 2, 1, 2];
        const result = maxCounters(N, A);
        expect(result).toEqual([2, 2]);
    });

    it('case 4: 2 counters, only one is set', () => {
        const N = 2;
        const A = [1, 1, 1, 1];
        const result = maxCounters(N, A);
        expect(result).toEqual([4, 0]);
    });

    it('case 5: 2 counters, set maximum', () => {
        const N = 2;
        const A = [1, 1, 1, 3];
        const result = maxCounters(N, A);
        expect(result).toEqual([3, 3]);
    });
    it('case 6, 2 counters, set maximum in the middle', () => {
        const N = 2;
        const A = [1, 1, 3, 2, 2];
        const result = maxCounters(N, A);
        expect(result).toEqual([2, 4]);
    });
    it('case 7, test case from the exam', () => {
        const N = 5;
        const A = [3, 4, 4, 6, 1, 4, 4];
        const result = maxCounters(N, A);
        expect(result).toEqual([3, 2, 2, 4, 2])
    });
});