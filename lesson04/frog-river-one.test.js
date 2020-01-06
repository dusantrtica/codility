import frogRiverOne from './frog-river-one';

describe('frogRiverOne', () => {
    it('should work for one step', () => {
        expect(frogRiverOne([1], 1)).toBe(0);        
    });

    it('should work for 2 steps, ', () => {
        expect(frogRiverOne([1, 1, 2], 2)).toBe(2);
        expect(frogRiverOne([1,2], 2)).toBe(1);
        expect(frogRiverOne([1,2,1,1], 2)).toBe(1);
    });

    it('should work for test case in the assignment', () => {
        expect(frogRiverOne([1,3,1,4,2,3,5,4], 5)).toBe(6)
    });

    it('should work for another case', () =>{
        expect(frogRiverOne([4, 4, 1, 2, 2, 1, 4, 3, 1], 4)).toBe(7);
    })
})