const Node = function (value) {
    this.value = value;
    this.next = null;
};

const LinkedList = function (initialArray = []) {
    this.head = null;
    [...initialArray].reverse().forEach(elem => {
        this.insertFirst(elem);
    });
}

LinkedList.prototype.insertFirst = function (value) {
    if (!this.head) {
        this.head = new Node(value);
    } else {
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }
}

LinkedList.prototype.insertLast = function (value) {
    const newNode = new Node(value);
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
        const newNode = new Node(value);
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

export const mergeSortedArrays = (a1, a2) => {
    const arr = [];
    const n1 = a1.length;
    const n2 = a2.length;

    let i = 0;
    let j = 0;

    while (i < n1 && j < n2) {
        if (a1[i] < a2[j]) {
            arr.push(a1[i]);
            i++;
            continue;
        } else {
            arr.push(a2[j]);
            j++;
            continue;
        }
    }

    if (j < n2) {
        while (j < n2) {
            arr.push(a2[j]);
            j++;
        }
    }

    if (i < n1) {
        while (i < n1) {
            arr.push(a1[i]);
            i++;
        }
    }

    return arr;
}

export default LinkedList;