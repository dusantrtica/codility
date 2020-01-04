import { Node, insertLast, insertFirst, insertAt, deleteHead, deleteTail } from './linked-list';
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
})