import { recContains, listFromArray, recCountElement, recSumElements, recMaxElem } from './linked-list-assignments';

describe('linked-list-assignments', () => {
    describe('recContains', () => {
        it('should return false for empty list', () => {
            const list = listFromArray();
            expect(recContains(list, 10)).toBe(false);
        });

        it('should work for one element list, ', () => {
            const list = listFromArray([1]);
            expect(recContains(list, 1)).toBe(true);
            expect(recContains(list, 2)).toBe(false);
        });

        it('should work for longer lists', () => {
            const list = listFromArray([0, 1, 2, 3]);
            expect(recContains(list, 2)).toBe(true);
            expect(recContains(list, 3)).toBe(true);
            expect(recContains(list, 10)).toBe(false);
        })
    });

    describe('recCountElement', () => {
        it('should work for empty list ', () => {
            const list = listFromArray();
            expect(recCountElement(list, 1)).toBe(0);
        });
        it('should wor for single element list', () => {
            const list = listFromArray([1]);
            expect(recCountElement(list, 1)).toBe(1);
            expect(recCountElement(list, 2)).toBe(0);
        });

        it('should work for longer lists', () => {
            const list = listFromArray([1, 2, 1, 1, 2, 3, 4]);
            expect(recCountElement(list, 1)).toBe(3);
            expect(recCountElement(list, 2)).toBe(2);
            expect(recCountElement(list, 3)).toBe(1);
            expect(recCountElement(list, 10)).toBe(0);
        })
    });

    describe('recSumElements', () => {
        it('should work for empty list', () => {
            const list = listFromArray();
            expect(recSumElements(list)).toBe(0);
        })
        it('should work for single element list', () => {
            const list = listFromArray([1]);
            expect(recSumElements(list)).toBe(1);
        });
        it('should work for longer list', () => {
            const list = listFromArray([1, 2, 3, 4]);
            expect(recSumElements(list)).toBe(10);
        })
    });

    describe('recMaxElem ', () => {
        it('should work for single element list', () => {
            const list = listFromArray([2]);
            expect(recMaxElem(list)).toBe(2);
        });

        it('should work for longer lists', () => {
            const list = listFromArray([2, 1, 5, 2, 8]);
            expect(recMaxElem(list)).toBe(8);
        });

        it('should work in case of negative values', () => {
            const list = listFromArray([-1, -2, -3, -4, -5]);
            expect(recMaxElem(list)).toBe(-1);
        });

        it('should consider 0 ', () => {
            const list = listFromArray([-1, -2, -3, 0, -9]);
            expect(recMaxElem(list)).toBe(0);
        })
    })
});