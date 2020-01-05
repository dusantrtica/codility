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

const BinaryTree = function () {
    this.root = null;
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

export default BinaryTree;