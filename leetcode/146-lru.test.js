var LRUCache = function (capacity) {
  this.map = new Object();
  this.size = 0;
  this.store = new DoublyLinkedList();
  this.capacity = capacity;
};

LRUCache.prototype.get = function (key) {
  if (!this.map[key]) {
    return -1;
  }
  const targetNode = this.map[key];
  targetNode.remove();
  this.map[targetNode.key] = this.store.append(targetNode.key, targetNode.val);
  return targetNode.val;
};

LRUCache.prototype.put = function (key, val) {
  if (this.map[key]) {
    const targetNode = this.map[key];
    targetNode.remove();
    this.size -= 1;
  }
  const newNode = this.store.append(key, val);
  this.map[key] = newNode;
  this.size += 1;
  if (this.size > this.capacity) {
    const firstNode = this.store.removeFirst();
    delete this.map[firstNode.key];
    this.size -= 1;
  }
};

// Creating a node class
function ListNode(key = null, val = null) {
  this.key = key;
  this.val = val;
  this.prev = null;
  this.next = null;
}

ListNode.prototype.remove = function () {
  this.prev.next = this.next;
  this.next.prev = this.prev;
  this.prev = null;
  this.next = null;
};

// Creating a doubly linked list
function DoublyLinkedList() {
  this.head = new ListNode();
  this.tail = new ListNode();
  this.head.next = this.tail;
  this.tail.prev = this.head;
}

DoublyLinkedList.prototype.append = function (key, val) {
  const newNode = new ListNode(key, val);
  const lastNode = this.tail.prev;

  lastNode.next = newNode;
  newNode.prev = lastNode;

  this.tail.prev = newNode;
  newNode.next = this.tail;

  return newNode;
};

DoublyLinkedList.prototype.removeFirst = function () {
  const firstNode = this.head.next;
  firstNode.remove();
  return firstNode;
};

describe('LRUcache', () => {
  it('case 1', () => {
    const cache = new LRUCache(2);
    const result = [
      cache.put(1, 1),
      cache.put(2, 2),
      cache.get(1), // returns 1
      cache.put(3, 3), // evicts key 2
      cache.get(2), // returns -1 (not found)
      cache.put(4, 4), // evicts key 1
      cache.get(1), // returns -1 (not found)
      cache.get(3), // returns 3
      cache.get(4),
    ];
    expect(result).toEqual([
      undefined,
      undefined,
      1,
      undefined,
      -1,
      undefined,
      -1,
      3,
      4,
    ]);
  });

  it('case 2', () => {
    const cache = new LRUCache(2);
    const result = [
      cache.put(2, 1),
      cache.put(2, 2),
      cache.get(2),
      cache.put(1, 1),
      cache.put(4, 1),
      cache.get(2),
    ];
  });
});
