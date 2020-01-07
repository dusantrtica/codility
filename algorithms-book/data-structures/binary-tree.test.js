import BinaryTree, { BinaryTreeNode } from "./binary-tree";

describe('BinaryTree', () => {
    describe('height', () => {
        it('should return 0 for empty tree', () => {
            const tree = new BinaryTree();
            expect(tree.height()).toBe(0);
        });
        it('should work for 1 elemenent tree', () => {
            const tree = new BinaryTree([1]);
            expect(tree.height()).toBe(1);
        });
        it('shold work for balanced tree with 3 elements', () => {
            const tree = new BinaryTree([2, 1, 3]);
            expect(tree.height()).toBe(2);
        });

        it('should work for unbalanced tree with 5 elements', () => {
            const tree = new BinaryTree([1, 2, 3, 4, 5]);
            expect(tree.height()).toBe(5);
        });

        it('should work for balanced tree with 9 elements', () => {
            const tree = new BinaryTree([5, 3, 7, 2, 4, 6, 8, 1, 9]);
            expect(tree.height()).toBe(4);
        })
    });
    describe('count ', () => {
        it('should work for 0 elem tree', () => {
            const tree = new BinaryTree();
            expect(tree.count()).toBe(0);
        });
        it('should work for on element tree', () => {
            const tree = new BinaryTree([1]);
            expect(tree.count()).toBe(1);
        });

        it('should work for 7 elements tree', () => {
            const tree = new BinaryTree([4, 3, 2, 6, 7, 8, 10]);
            expect(tree.count()).toBe(7);
        })
    });
    describe('constructor ', () => {
        it('should create zero element tree', () => {
            const tree = new BinaryTree();
            expect(tree.root).toEqual(null);
        })
        it('should create one element tree', () => {
            const tree = new BinaryTree([1]);
            expect(tree.root).toEqual({ value: 1, left: null, right: null });
        });

        it('should create 3 element tree', () => {
            const tree = new BinaryTree([2, 1, 3]);
            const left = new BinaryTreeNode(1);
            const right = new BinaryTreeNode(3);
            expect(tree.root).toEqual({ value: 2, left, right });
        });

        it('should create unbalanced 4 element tree', () => {
            const tree = new BinaryTree([1, 2, 3, 4]);
            const right1 = new BinaryTreeNode(4);
            const right2 = new BinaryTreeNode(3);
            right2.right = right1;
            const right = new BinaryTreeNode(2);
            right.right = right2;
            expect(tree.root).toEqual({ value: 1, left: null, right });
        })
    })
    describe('Insert', () => {
        it('should insert single node in a tree', () => {
            const tree = new BinaryTree();
            tree.insert(1);
            expect(tree.root).toEqual({ value: 1, left: null, right: null });
            const result = tree.prefix();
            expect(result).toEqual([1])
        });

        it('should insert one root and one element to the left', () => {
            const tree = new BinaryTree();
            tree.insert(2);
            tree.insert(1);

            const left = new BinaryTreeNode(1);

            expect(tree.root).toEqual({ value: 2, left, right: null });
            expect(tree.prefix()).toEqual([1, 2])
        });

        it('should insert three nodes, one root, one left and one right', () => {
            const tree = new BinaryTree();
            tree.insert(2);
            tree.insert(1);
            tree.insert(3);

            const right = new BinaryTreeNode(3);
            const left = new BinaryTreeNode(1);

            expect(tree.root).toEqual({ left, right, value: 2 });
            expect(tree.prefix()).toEqual([1, 2, 3])
        });

        it('should create unbalanced tree, like a list', () => {
            const tree = new BinaryTree();
            tree.insert(1);
            tree.insert(2);
            tree.insert(3);

            const right = new BinaryTreeNode(2);
            right.right = new BinaryTreeNode(3)

            expect(tree.root).toEqual({ value: 1, left: null, right });
        });
    })
})