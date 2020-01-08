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

BinaryTreeNode.prototype.level = function (result, currentLevel, n) {
    if (currentLevel === n) {
        result.push(this.value);
    }

    if (this.left) {
        this.left.level(result, currentLevel + 1, n);
    }

    if (this.right) {
        this.right.level(result, currentLevel + 1, n);
    }
}

BinaryTreeNode.prototype.maxOnLevel = function (currentLevel, n) {
    if (currentLevel === n) {
        return this.value;
    }

    const leftMaxOnLevel = this.left ? this.left.maxOnLevel(currentLevel + 1, n) : null;
    const rightMaxOnLevel = this.right ? this.right.maxOnLevel(currentLevel + 1, n) : null;

    if (leftMaxOnLevel !== null && rightMaxOnLevel !== null) {
        return Math.max(leftMaxOnLevel, rightMaxOnLevel);
    } else if (rightMaxOnLevel !== null) {
        return rightMaxOnLevel;
    }

    return leftMaxOnLevel;
}

BinaryTreeNode.prototype.sumOnLevel = function (currentLevel, n) {
    if (currentLevel === n) {
        return this.value;
    }

    const sumOnLeftLevel = this.left ? this.left.sumOnLevel(currentLevel + 1, n) : null;
    const sumOnRightLevel = this.right ? this.right.sumOnLevel(currentLevel + 1, n) : null;

    if (sumOnRightLevel === null && sumOnLeftLevel === null) {
        return null;
    }

    return (sumOnLeftLevel || 0) + (sumOnRightLevel || 0);
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

BinaryTree.prototype.level = function (n) {
    const result = []
    if (!this.root || n < 0) {
        return result;
    }

    this.root.level(result, 0, n);
    return result;
}

BinaryTree.prototype.maxOnLevel = function (n) {
    if (!this.root) {
        return null;
    }

    return this.root.maxOnLevel(0, n);
}

BinaryTree.prototype.sumOnLevel = function (n) {
    if (!this.root) {
        return null;
    }

    return this.root.sumOnLevel(0, n);
}

export default BinaryTree;