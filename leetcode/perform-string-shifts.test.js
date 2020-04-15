const stringShift = (s, shift) => {
  const n = s.length;
  const shiftsAggregated = shift.reduce((acc, curr) => {
    const [direction, amount] = curr;
    if (direction) {
      return acc + amount;
    } else {
      return acc - amount;
    }
  }, 0);

  const sArray = [...s];
  const rotationCount = shiftsAggregated % n;
  if (!rotationCount) {
    return s;
  } else if (rotationCount > 0) {
    for (let i = 0; i < rotationCount; i++) {
      sArray.unshift(sArray.pop());
    }
  } else {
    for (let i = 0; i > rotationCount; i--) {
      sArray.push(sArray.shift());
    }
  }
  return sArray.join('');
};

describe('stringShifts', () => {
  it('case 1', () => {
    expect(
      stringShift('abc', [
        [0, 1],
        [1, 2],
      ]),
    ).toBe('cab');
  });

  it('case 2', () => {
    expect(
      stringShift('abcdefg', [
        [1, 1],
        [1, 1],
        [0, 2],
        [1, 3],
      ]),
    ).toBe('efgabcd');
  });
});
