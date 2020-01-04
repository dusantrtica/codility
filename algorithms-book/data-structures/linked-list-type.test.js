import LinkedList from './linked-list-type';

describe('LinkedList', () => {
    describe('insertFirst', () => {
        it('should insert one element on the beginning', () => {
            const list = new LinkedList();
            list.insertFirst(1);
            expect(list.toArray()).toEqual([1]);
        });

        it('should insert 2 elements on the beginngin', () => {
            const list = new LinkedList();
            list.insertFirst(1);
            list.insertFirst(2);
            expect(list.toArray()).toEqual([2, 1])
        });
    });

    describe('insertLast', () => {
        it('should add one elemeent list', () => {
            const list = new LinkedList();
            list.insertLast(10);
            expect(list.toArray()).toEqual([10]);
        });

        it('should add two elements ', () => {
            const list = new LinkedList();
            list.insertLast(10);
            list.insertLast(11);
            expect(list.toArray()).toEqual([10, 11]);
        })
    });

    describe('LinkedList constructor', () => {
        it('should create empty list', () => {
            const list = new LinkedList([]);
            expect(list.toArray()).toEqual([]);
        });
        it('should create one element array', () => {
            const list = new LinkedList([1]);
            expect(list.toArray()).toEqual([1]);
        });
        it('should create 3 elements list', () => {
            const list = new LinkedList([1, 2, 3]);
            expect(list.toArray()).toEqual([1, 2, 3])
        })
    });

    describe('insertAt', () => {
        it('should insertAt to empty list, first element, ', () => {
            const list = new LinkedList();
            list.insertAt(1, 0);
            expect(list.toArray()).toEqual([1]);
        });

        it('should insertAt to not empty list first element', () => {
            const list = new LinkedList([1]);
            list.insertAt(2, 0);
            expect(list.toArray()).toEqual([2, 1]);
        });

        it('should insert last element to list', () => {
            const list = new LinkedList([1]);
            list.insertAt(2, 1);
            expect(list.toArray()).toEqual([1, 2]);
        });

        it('should insert element in the middle', () => {
            const list = new LinkedList([1, 2, 3]);
            list.insertAt(101, 1);
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
            expect(list.toArray()).toEqual([]);
        })
        it('should remove latest element of a list', () => {
            const list = new LinkedList([1, 2, 3]);
            list.removeLast();
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
            expect(list.toArray()).toEqual([2, 3]);
        });

        it('should remove elem on the 1st place (middle)', () => {
            list.removeAt(1);
            expect(list.toArray()).toEqual([1, 3]);
        });

        it('should remove elem on the last place', () => {
            list.removeAt(2);
            expect(list.toArray()).toEqual([1, 2])
        })
    })
})