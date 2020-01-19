import { recContains, listFromArray, recCountElement, recSumElements, recMaxElem, recReplaceAll, recReplaceFirst, recRemoveAll } from './linked-list-assignments';

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
    });

    describe('recReplaceAll', () => {
        it('should work for empty list', () => {
            const list = listFromArray([]);
            recReplaceAll(list, 1, 2);
            expect(list).toEqual({});
        });

        it('should replace element in one element list', () => {
            const list = listFromArray([1]);
            recReplaceAll(list, 1, 2);
            expect(list).toEqual({ next: null, value: 2 });
        });

        it('should replace elements in a list', () => {
            const list = listFromArray([2, 2, 2, 1]);
            recReplaceAll(list, 2, 1);
            expect(list).toEqual({ value: 1, next: { value: 1, next: { value: 1, next: { value: 1, next: null } } } });
        });

        it('should not replace elements if there is no such element', () => {
            const list = listFromArray([1, 2, 3]);
            recReplaceAll(list, 5, 1);
            expect(list).toEqual(list);
        });
    });

    describe('recReplaceFirst', () => {
        it('should work for empty list', () => {
            const list = listFromArray([]);
            recReplaceFirst(list, 1, 2);
            expect(list).toEqual({});
        });

        it('should replace element in one element list', () => {
            const list = listFromArray([1]);
            recReplaceFirst(list, 1, 2);
            expect(list).toEqual({ next: null, value: 2 });
        });

        it('should replace elements in a list', () => {
            const list = listFromArray([2, 2, 2, 1]);
            recReplaceFirst(list, 2, 1);
            expect(list).toEqual({ value: 1, next: { value: 2, next: { value: 2, next: { value: 1, next: null } } } });
        });

        it('should not replace elements if there is no such element', () => {
            const list = listFromArray([1, 2, 3]);
            recReplaceFirst(list, 5, 1);
            expect(list).toEqual(list);
        });

        it('should replace first element', () => {
            const list = listFromArray([1, 2, 1, 3, 2, 1]);
            recReplaceFirst(list, 2, 5);
            expect(list).toEqual(listFromArray([1, 5, 1, 3, 2, 1]));
        });

        it('should replace the latst element', () => {
            const list = listFromArray([1, 2, 3]);
            recReplaceFirst(list, 3, 0);
            expect(list).toEqual(listFromArray([1, 2, 0]));
        });
    });
});