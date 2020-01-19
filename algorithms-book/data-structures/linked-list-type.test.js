import LinkedList, { mergeSortedArrays } from './linked-list-type';

describe('LinkedList', () => {
    describe('insertFirst', () => {
        it('should insert one element on the beginning', () => {
            const list = new LinkedList();
            list.insertFirst(1);
            expect(list.head).toEqual({ next: null, value: 1 })
            expect(list.toArray()).toEqual([1]);
        });

        it('should insert 2 elements on the beginngin', () => {
            const list = new LinkedList();
            list.insertFirst(1);
            list.insertFirst(2);
            expect(list.head).toEqual({ value: 2, next: { value: 1, next: null } })
            expect(list.toArray()).toEqual([2, 1])
        });
    });

    describe('insertLast', () => {
        it('should add one elemeent list', () => {
            const list = new LinkedList();
            list.insertLast(10);
            expect(list.head).toEqual({ value: 10, next: null });
            expect(list.toArray()).toEqual([10]);
        });

        it('should add two elements ', () => {
            const list = new LinkedList();
            list.insertLast(10);
            list.insertLast(11);
            expect(list.head).toEqual({ value: 10, next: { value: 11, next: null } });
            expect(list.toArray()).toEqual([10, 11]);
        })
    });

    describe('LinkedList constructor', () => {
        it('should create empty list', () => {
            const list = new LinkedList([]);
            expect(list.head).toEqual(null);
            expect(list.toArray()).toEqual([]);
        });
        it('should create one element array', () => {
            const list = new LinkedList([1]);
            expect(list.head).toEqual({ value: 1, next: null });
            expect(list.toArray()).toEqual([1]);
        });
        it('should create 3 elements list', () => {
            const list = new LinkedList([1, 2, 3]);
            expect(list.head).toEqual({ value: 1, next: { value: 2, next: { value: 3, next: null } } })
            expect(list.toArray()).toEqual([1, 2, 3])
        })
    });

    describe('insertAt', () => {
        it('should insertAt to empty list, first element, ', () => {
            const list = new LinkedList();
            list.insertAt(1, 0);
            expect(list.head).toEqual({ next: null, value: 1 });
            expect(list.toArray()).toEqual([1]);
        });

        it('should insertAt to not empty list first element', () => {
            const list = new LinkedList([1]);
            list.insertAt(2, 0);
            expect(list.head).toEqual({ value: 2, next: { value: 1, next: null } });
            expect(list.toArray()).toEqual([2, 1]);
        });

        it('should insert last element to list', () => {
            const list = new LinkedList([1]);
            list.insertAt(2, 1);
            expect(list.head).toEqual({ value: 1, next: { value: 2, next: null } });
            expect(list.toArray()).toEqual([1, 2]);
        });

        it('should insert element in the middle', () => {
            const list = new LinkedList([1, 2, 3]);
            list.insertAt(101, 1);
            expect(list.head).toEqual({ value: 1, next: { value: 101, next: { value: 2, next: { value: 3, next: null } } } });
            expect(list.toArray()).toEqual([1, 101, 2, 3]);
        });
    });

    describe('getAt', () => {
        it('should return nth elem', () => {
            const list = new LinkedList([1, 2, 3]);
            expect(list.getAt(0)).toEqual(1);
            expect(list.getAt(1)).toEqual(2);
            expect(list.getAt(2)).toEqual(3);
        })
    });

    describe('removeLast', () => {
        it('should remove latest elem of one elemlist', () => {
            const list = new LinkedList([1]);
            list.removeLast();
            expect(list.head).toEqual(null);
            expect(list.toArray()).toEqual([]);
        })
        it('should remove latest element of a list', () => {
            const list = new LinkedList([1, 2, 3]);
            list.removeLast();
            expect(list.head).toEqual({ value: 1, next: { value: 2, next: null } });
            expect(list.toArray()).toEqual([1, 2]);
        })
    });

    describe('removeFirst', () => {
        it('should work in 0th elems list', () => {
            const list = new LinkedList();
            list.removeFirst();
            expect(list.toArray()).toEqual([]);
        });

        it('should work for 1 elem list', () => {
            const list = new LinkedList([1]);
            list.removeFirst();
            expect(list.toArray()).toEqual([]);
        });
        it('should work for 2 elems list', () => {
            const list = new LinkedList([1, 2]);
            list.removeLast();
            expect(list.toArray()).toEqual([1]);
        })
    });

    describe('removeAt', () => {
        let list;
        beforeEach(() => {
            list = new LinkedList([1, 2, 3]);
        })
        it('should remove elem on the 0th place, ', () => {
            list.removeAt(0);
            expect(list.head).toEqual({ value: 2, next: { value: 3, next: null } });
            expect(list.toArray()).toEqual([2, 3]);
        });

        it('should remove elem on the 1st place (middle)', () => {
            list.removeAt(1);
            expect(list.head).toEqual({ value: 1, next: { next: null, value: 3 } });
            expect(list.toArray()).toEqual([1, 3]);
        });

        it('should remove elem on the last place', () => {
            list.removeAt(2);
            expect(list.head).toEqual({ value: 1, next: { next: null, value: 2 } });
            expect(list.toArray()).toEqual([1, 2])
        })
    });

    describe.skip('recRemoveAll', () => {
        it('should remove the only element in the list', () => {
            const list = new LinkedList([1]);
            list.recRemoveAll(1)
            expect(list.head).toEqual(null);
        });

        it('should remove second element in 2 elemements list', () => {
            const list = new LinkedList([1, 2]);
            list.recRemoveAll(2);
            expect(list.head).toEqual({ value: 1, next: null });
        });
        it('should remove first element in 2 elements list', () => {
            const list = new LinkedList([1, 2]);

            list.recRemoveAll(1);
            expect(list.head).toEqual({ value: 2, next: null });
        });
        it('should remove second element in 3 elements list', () => {
            const list = new LinkedList([1, 2, 3]);
            list.recRemoveAll(2);
            expect(list.head).toEqual({ value: 1, next: { value: 3, next: null } });
        });
        it('should leave list intact if the element is not found', () => {
            const list = new LinkedList([1, 2, 3]);
            list.recRemoveAll(5);
            expect(list).toEqual(list);
        })
    });

    describe('mergeSortedArrays', () => {
        it('case 1', () => {
            expect(mergeSortedArrays([1], [])).toEqual([1])
            expect(mergeSortedArrays([], [1])).toEqual([1])
        });
        it('case 2', () => {
            expect(mergeSortedArrays([1], [1])).toEqual([1, 1]);
        });
        it('case 3', () => {
            expect(mergeSortedArrays([1], [2])).toEqual([1, 2]);
            expect(mergeSortedArrays([2], [1])).toEqual([1, 2]);
        });
        it('case 4 ', () => {
            expect(mergeSortedArrays([1, 3], [2, 4])).toEqual([1, 2, 3, 4]);
            expect(mergeSortedArrays([2, 4], [1, 3])).toEqual([1, 2, 3, 4]);
        })
    })

    describe.skip('mergeSortedLists', () => {
        it('should merge list with empty list', () => {
            const l1 = new LinkedList([1, 2]);
            const l2 = new LinkedList([]);
            const l3 = mergeSortedLists(l1, l2);
            expect(l1.head).toEqual({ value: 1, next: { value: 2, next: null } });
        });

        it('case 2', () => {
            const l1 = new LinkedList([1]);
            const l2 = new LinkedList([1]);
            const l3 = mergeSortedLists(l1, l2);
            expect(l1.head).toEqual({ value: 1, next: { value: 1, next: null } });
        });

        it('case 3 ', () => {
            const l1 = new LinkedList([1]);
            const l2 = new LinkedList([2]);
            expect(l1.head).toEqual({ value: 1, next: { value: 2, next: null } });
        });

        it('case 4', () => {
            const l1 = new LinkedList([1, 4, 6]);
            const l2 = new LinkedList([2, 5, 7]);
            const l3 = mergeSortedLists(l1, l2);
            expect(l1.toArray()).toEqual([1, 2, 4, 5, 6, 7]);
        })
    })
})