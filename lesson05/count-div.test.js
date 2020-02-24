import { countDiv } from './count-div';

describe('countDiv', () => {
    it('test case 1', () => {
        expect(countDiv(6, 11, 2)).toBe(3);
    });
    it('test case 2', () => {
        expect(countDiv(2, 10, 1)).toBe(9);
    })
    it('test case 3', () => {
        expect(countDiv(2, 10, 2)).toBe(5);
    })
    it('test case 4', () => {
        expect(countDiv(2, 10, 3)).toBe(3);
    })
    it('test case 5', () => {
        expect(countDiv(1, 1, 1)).toBe(1);
    })
    it('test case 6', () => {
        expect(countDiv(1, 1, 2)).toBe(0);
    })
    it('test case 7', () => {
        expect(countDiv(1, 10, 10)).toBe(1);
    })
    it('test case 8', () => {
        expect(countDiv(1, 9, 10)).toBe(0);
    });
    it('test case 9', () => {
        expect(countDiv(11, 345, 17)).toBe(20);
    });
    it('test case 10', () => {
        expect(countDiv(0, 0, 11)).toBe(1);
        expect(countDiv(1, 1, 11)).toBe(1);
    });
    it('test case 11', () => {
        expect(countDiv(10, 10, 5)).toBe(0);
    });
    it('test case 12', () => {
        expect(countDiv(10, 10, 7)).toBe(0);
        expect(countDiv(10, 10, 20)).toBe(0);
    });
    it('test case 13', () => {
        expect(countDiv(11, 13, 12)).toBe(1);
    })
})