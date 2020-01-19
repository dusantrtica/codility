import { Node, insertLast, insertFirst, insertAt, deleteHead, deleteTail, addTwoNumbers } from './linked-list';
import { listFromArray } from './linked-list-assignments';
const convertToArray = (head) => {
    const values = [];
    while (head) {
        const { value } = head;
        values.push(value);
        head = head.next;
    }

    return values;
}

describe('linked-list', () => {
    it('should work with one element list', () => {
        const head = Node(10);
        expect(convertToArray(head)).toEqual([10])
    });
    describe('insertLast', () => {
        it('should create a list with 2 elements', () => {
            const head = Node(10);
            insertLast(head, 11);
            expect(convertToArray(head)).toEqual([10, 11]);
        });
        it('should create a list with 3 elements', () => {
            const head = Node(10);
            insertLast(head, 11);
            insertLast(head, 13);
            expect(convertToArray(head)).toEqual([10, 11, 13]);
        });
    });
    describe('insertFirst', () => {
        it('should insert element before the head', () => {
            const head = Node(10);
            insertFirst(head, 11);
            expect(convertToArray(head)).toEqual([11, 10])
        });

        it('should insert 2 elements before head', () => {
            const head = Node(10);
            insertFirst(head, 11);
            insertFirst(head, 12);
            expect(convertToArray(head)).toEqual([12, 11, 10]);
        });
    });

    describe('insertAt', () => {
        let head;
        beforeEach(() => {
            head = Node(10);
            insertLast(head, 11);
            insertLast(head, 12);
            insertLast(head, 13);
        });

        it('should insert at the 0th place', () => {
            insertAt(head, 0, 9);
            expect(convertToArray(head)).toEqual([9, 10, 11, 12, 13])
        });

        it('should insert at the first place', () => {
            insertAt(head, 1, 101);
            expect(convertToArray(head)).toEqual([10, 101, 11, 12, 13])
        });

        it('should insert at the second place ', () => {
            insertAt(head, 2, 101);
            expect(convertToArray(head)).toEqual([10, 11, 101, 12, 13])
        })

        it('should insert last', () => {
            insertAt(head, 4, 14);
            expect(convertToArray(head)).toEqual([10, 11, 12, 13, 14]);
        });

        it('should insert one before last', () => {
            insertAt(head, 3, 101);
            expect(convertToArray(head)).toEqual([10, 11, 12, 101, 13]);
        });
    });

    describe('addTwoNumbers', () => {
        it('case 1, sum', () => {
            const l1 = listFromArray([1]);
            const l2 = listFromArray([2]);
            const l3 = addTwoNumbers(l1, l2);
            expect(l3).toEqual(listFromArray([3]));
        });

        it('case 2, sum 2 numbers with carry digit', () => {
            const l1 = listFromArray([6]);
            const l2 = listFromArray([7]);
            const l3 = addTwoNumbers(l1, l2);
            expect(l3).toEqual(listFromArray([3, 1]));
        });

        it('case 3, sum 2 numbers that are not equal in length', () => {
            const l1 = listFromArray([2]);
            const l2 = listFromArray([2, 1]);
            const l3 = addTwoNumbers(l1, l2);
            expect(l3).toEqual(listFromArray([4, 1]));
        });

        it('case 4, sum 2 numbers of different length with carry digit ', () => {
            const l1 = listFromArray([6]);
            const l2 = listFromArray([7, 1]);
            const l3 = addTwoNumbers(l1, l2);
            expect(l3).toEqual(listFromArray([3, 2]));
        });

        it('case 5, from the test assignment', () => {
            const l1 = listFromArray([2, 4, 3]);
            const l2 = listFromArray([5, 6, 4]);
            const l3 = addTwoNumbers(l1, l2);
            expect(l3).toEqual(listFromArray([7, 0, 8]));
        })
    })
})