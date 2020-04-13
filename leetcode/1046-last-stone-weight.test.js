const lastStoneWeight = (stones) => {
  if (stones.length === 0) {
    return 0;
  }

  if (stones.length === 1) {
    return 1;
  }

  while (stones.length > 1) {
    stones.sort((a, b) => a - b);
    const n = stones.length;
    const s1 = stones[n - 1];
    const s2 = stones[n - 2];
    if (s1 === s2) {
      stones.pop();
      stones.pop();
    } else {
      const diff = s1 - s2;
      stones[n - 2] = diff;
      stones.pop();
    }
  }

  if (stones.length) {
    return stones[stones.length - 1];
  }
  return 0;
};

describe('lastStonesWeight', () => {
  it('case 1', () => {
    expect(lastStoneWeight([2, 7, 4, 1, 8, 1])).toBe(1);
  });
  it('case 2', () => {
    expect(lastStoneWeight([2, 2])).toBe(0);
  });
  it('case 3', () => {
    expect(lastStoneWeight([8, 10, 4])).toBe(2);
  });
});
