const Node = (value) => ({
    value,
    next: null
});

const LinkedList = function (initialArray = []) {
    this.head = null;
    [...initialArray].reverse().forEach(elem => {
        this.insertFirst(elem);
    });
}

LinkedList.prototype.insertFirst = function (value) {
    if (!this.head) {
        this.head = Node(value);
    } else {
        const newNode = Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }
}

LinkedList.prototype.insertLast = function (value) {
    const newNode = Node(value);
    if (!this.head) {
        this.head = newNode;
    } else {
        let curr = this.head;
        while (curr.next) {
            curr = curr.next;
        }

        curr.next = newNode;
    }
}

LinkedList.prototype.insert = LinkedList.prototype.insertLast;

// [1,9,2,3]
LinkedList.prototype.insertAt = function (value, pos) {
    if (pos === 0) {
        this.insertFirst(value);
    } else {
        const newNode = Node(value);
        let currNode = this.head;
        let counter = 0;
        while (currNode && counter < pos - 1) {
            currNode = currNode.next;
            counter += 1;
        }

        if (currNode) {
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    }
}

LinkedList.prototype.getAt = function (pos) {
    let currNode = this.head;
    let counter = 0;
    while (currNode && counter < pos) {
        counter += 1;
        currNode = currNode.next;
    }

    return currNode.value;
}

LinkedList.prototype.removeLast = function () {
    if (!this.head.next) {
        this.head = null;
    } else {
        let currNode = this.head;
        while (currNode.next.next) {
            currNode = currNode.next;
        }

        currNode.next = null;
    }
}

LinkedList.prototype.removeFirst = function () {
    if (!this.head || !this.head.next) {
        this.head = null;
    } else {
        this.head = this.head.next;
    }
}

LinkedList.prototype.removeAt = function (pos) {
    if (pos === 0) {
        this.removeFirst();
    } else {
        let currNode = this.head;
        let count = 0;
        while (count < pos - 1 && currNode.next) {
            count += 1;
            currNode = currNode.next;
        };

        if (currNode.next) {
            currNode.next = currNode.next.next;
        }
    }
}

LinkedList.prototype.toArray = function () {
    const values = [];
    let currentHead = this.head;

    while (currentHead) {
        values.push(currentHead.value);
        currentHead = currentHead.next;
    }

    return values;
}

export default LinkedList;