export const BinaryTreeNode = function (value) {
    this.right = null;
    this.left = null;
    this.value = value;
}

BinaryTreeNode.prototype.insert = function (value) {
    const { value: nodeValue } = this;
    if (value < nodeValue) {
        if (!this.left) {
            this.left = new BinaryTreeNode(value);
        } else {
            this.left.insert(value);
        }
    } else if (value >= nodeValue) {
        if (!this.right) {
            this.right = new BinaryTreeNode(value);
        } else {
            this.right.insert(value);
        }
    }
}

BinaryTreeNode.prototype.prefix = function (result) {
    if (this.left) {
        this.left.prefix(result);
    }
    result.push(this.value);
    if (this.right) {
        this.right.prefix(result);
    }
}

BinaryTreeNode.prototype.count = function () {
    const leftCount = this.left !== null ? this.left.count() : 0;
    const rightCount = this.right !== null ? this.right.count() : 0;
    return 1 + leftCount + rightCount;
}

BinaryTreeNode.prototype.height = function () {
    const leftHeight = this.left !== null ? this.left.height() : 0;
    const rightHeight = this.right !== null ? this.right.height() : 0;

    return 1 + Math.max(leftHeight, rightHeight);
}

const BinaryTree = function (initialValues = []) {
    this.root = null;
    initialValues.forEach(value => { this.insert(value) })
}

BinaryTree.prototype.insert = function (value) {
    if (!this.root) {
        this.root = new BinaryTreeNode(value);
    } else {
        this.root.insert(value);
    }
}

BinaryTree.prototype.prefix = function () {
    const result = []
    if (this.root) {
        this.root.prefix(result);
    }

    return result;
}

BinaryTree.prototype.count = function () {
    if (this.root) {
        return this.root.count();
    }
    return 0;
}

BinaryTree.prototype.height = function () {
    if (this.root) {
        return this.root.height();
    }

    return 0;
}

export default BinaryTree;