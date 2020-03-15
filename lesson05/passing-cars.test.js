import passingCars from './passing-cars';

describe('passingCars', () => {
    it('case 1', () => {
        expect(passingCars([0, 1])).toBe(1);
    });
    it('case 2', () => {
        expect(passingCars([0])).toBe(0);
        expect(passingCars([1])).toBe(0);
    });
    it('case 3', () => {
        expect(passingCars([0, 0, 1])).toBe(2);
    });
    it('case 4', () => {
        expect(passingCars([0, 0, 1, 1])).toBe(4);
    });
    it('case 5', () => {
        expect(passingCars([0, 1, 0, 1, 1])).toBe(5);
    });

    it('case 6', () => {
        const A = Array(64000).fill(1);
        for (let i = 0; i < 32000; i++) {
            A[i] = 0;
        }
        expect(passingCars(A)).toBe(-1);
    });
    it('case 7', () => {
        const A = Array(100000).fill(0);
        expect(passingCars(A)).toBe(0);
    });
    it('case 8', () => {
        const A = Array(100000).fill(1);
        expect(passingCars(A)).toBe(0);
    })
})