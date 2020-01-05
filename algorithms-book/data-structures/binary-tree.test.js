import BinaryTree, { BinaryTreeNode } from "./binary-tree";

describe('BinaryTree', () => {
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
        })
    })
})