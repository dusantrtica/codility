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
export const deleteHead = (head) => { }

export const deleteAt = (head, pos) => { }
