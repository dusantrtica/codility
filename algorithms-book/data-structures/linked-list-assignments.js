/** Cabarkapa  */

import { insertFirst, Node } from './linked-list';

// Util function to ease testing
export const listFromArray = (initialArray = []) => {
    if (initialArray.length === 0) {
        return {};
    }
    const reversedArray = [...initialArray].reverse();
    const [first, ...rest] = reversedArray;
    const head = Node(first);
    rest.forEach(elem => insertFirst(head, elem));
    return head;
};

// recursively tests if value is in list
export const recContains = (node, value) => {
    if (!node) {
        return false;
    }
    if (node.value === value) {
        return true;
    }

    return recContains(node.next, value);
}

// recursively counts value occurence
export const recCountElement = (node, value) => {
    if (!node) {
        return 0;
    }

    return (node.value === value ? 1 : 0) + recCountElement(node.next, value);
}

// recursively sums list elements
export const recSumElements = (node) => {
    if (!node || !node.value) {
        return 0;
    }

    return node.value + recSumElements(node.next);
}

export const recMaxElem = (node) => {
    if (!node) {
        return null;
    }

    const { value } = node;
    const restMax = recMaxElem(node.next);
    if (restMax === null) {
        return value;
    }

    return Math.max(value, restMax);
}