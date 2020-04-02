const isHappy = (n) => {
  const visitedNumbers = {};
  let num = n;
  while (true) {
    const digits = [...`${num}`].map((e) => parseInt(e));
    const sum = digits.reduce((acc, curr) => acc + curr * curr, 0);
    if (visitedNumbers[sum]) {
      return false;
    }
    if (sum === 1) {
      return true;
    } else {
      num = sum;
      visitedNumbers[sum] = true;
    }
  }
};

describe('isHappy', () => {
  it('case 1', () => {
    expect(isHappy(19)).toBe(true);
  });

  it('case 2', () => {
    expect(isHappy(2)).toBe(false);
  });
});
