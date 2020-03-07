import genomicRange from './genomic-range';

describe('genomicRange', () => {
    describe('genomicRange, one element PQ arrays', () => {
        it('case 1', () => {
            const A = 'ACGT';
            expect(genomicRange(A, [0], [3])).toEqual([1]);
        });
        it('case 2', () => {
            const A = 'ACGT';
            expect(genomicRange(A, [1], [1])).toEqual([2]);
        });
        it('case 3', () => {
            const A = 'ACGT';
            expect(genomicRange(A, [1], [2])).toEqual([2]);
        });
        it('case 4', () => {
            const A = 'ACGTGT';
            expect(genomicRange(A, [3], [5])).toEqual([3]);
        });
    });
    describe('genomicRange, PQ multi elem arrays', () => {
        it('case 5', () => {
            const A = 'ACGTGTCAAC';
            expect(genomicRange(A, [0, 0], [0, 0])).toEqual([1, 1]);
        })
        it('case 6', () => {
            const A = 'ACGTGTCAAC';
            expect(genomicRange(A, [0, 0], [9, 9])).toEqual([1, 1]);
        });
        it('case 7', () => {
            const A = 'ACGTGTCAAC';
            expect(genomicRange(A, [1, 2], [5, 7])).toEqual([2, 1]);
        });
        it('case 8', () => {
            const A = 'CGTGTCTC';
            expect(genomicRange(A, [1, 5, 2], [2, 7, 4])).toEqual([3, 2, 3]);
        });
        it('case 9, ', () => {
            const A = 'CAGCCTA';
            expect(genomicRange(A, [2, 5, 0], [4, 5, 6])).toEqual([2, 4, 1])
        })
    })
})