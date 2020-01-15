import missingInteger from './missing-integer';

describe('missingInteger ', () => {
    it('should pass for one element array', () => {
        expect(missingInteger([1])).toBe(2);
        expect(missingInteger([12])).toBe(1);
    });

    it('should work for one element array with negative values', () =>{
        expect(missingInteger([-3])).toBe(1);
        expect(missingInteger([-10])).toBe(1);
    });

    it('should work for test case 1', () => {
        const A = [1, 3, 6, 4, 1, 2];
        expect(missingInteger(A)).toBe(5);
    });

    it('should work for test case 2', () => {
        const A =[1,2,3];
        expect(missingInteger(A)).toBe(4);
    });

    it('should work for test case 3', () => {
        const A = [-1,-3];
        expect(missingInteger(A)).toBe(1);
    });

    it('should work for mixing values (positive and negative)', () => {
        const A =[-1, -3, 6];
        expect(missingInteger(A)).toBe(1);
    });

    it('should work for mixing positive and negative values', ()=>{
        const A = [-3, 1, 4];
        expect(missingInteger(A)).toBe(2);
    });

    it('should work when minimum value in A is bigger than 1', () => {
        const A = [5,3,6,11,4];
        expect(missingInteger(A)).toBe(1);
    });
    it('some more test cases', () => {
        const A = [5,3,6,11,4, 2, 1];
        expect(missingInteger(A)).toBe(7);
    });
    it('when 1 is in array', () => {
        expect(missingInteger([-2,-3,1])).toBe(2);
    })
});
