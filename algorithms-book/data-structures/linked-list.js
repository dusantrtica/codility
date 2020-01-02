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
    while (count < pos && head.next) {
        count += 1;
        head = head.next;
    }

    if (head.next) {
        const node = Node(head.value);
        node.next = head.next;
        head.next = node;
        head.value = value;
    } else {
        head.next = Node(value);
    }
}

