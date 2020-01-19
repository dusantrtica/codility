export const Node = (value) => ({
    value,
    next: null
});

export const insertLast = (head, value) => {
    while (head.next) {
        head = head.next;
    }

    head.next = Node(value);
}

export const insertFirst = (head, value) => {
    const second = Node(head.value);
    second.next = head.next;
    head.next = second;
    head.value = value;
}

export const insertAt = (head, pos, value) => {
    let count = 0;
    if (pos === 0) {
        insertFirst(head, value);
        return;
    }
    while (count < pos - 1 && head.next) {
        count += 1;
        head = head.next;
    }

    const newNode = Node(value);
    newNode.next = head.next;
    head.next = newNode;
}

// [12]
export const deleteTail = (head) => {
    while (head.next) {
        head = head.next;
    }


}

export const addTwoNumbers = function (l1, l2) {
    var carryDigit = 0;
    var head = null;
    var currNode = null;

    while (l1 || l2) {
        var tempSum = 0;
        var val = 0;
        tempSum = (l1 ? l1.value : 0) + (l2 ? l2.value : 0) + carryDigit;
        if (tempSum >= 10) {
            val = tempSum % 10;
            carryDigit = 1;
        } else {
            val = tempSum;
            carryDigit = 0;
        }
        if (!head) {
            head = Node(val);
            currNode = head;
        } else {
            const tmpNode = Node(val);
            currNode.next = tmpNode;
            currNode = tmpNode;
        }
        if (l1) { l1 = l1.next; }
        if (l2) { l2 = l2.next; }
    }
    if (carryDigit) {
        const tmpNode = Node(carryDigit);
        currNode.next = tmpNode;
        currNode = tmpNode;
    }
    return head;
};