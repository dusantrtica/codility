const maxSubArray = (A) => {
  const n = A.length;
  let maxSum = A[0];
  let localSum = A[0];

  for (let i = 1; i < n; i++) {
    if (A[i] > localSum + A[i]) {
      localSum = A[i];
    } else {
      localSum += A[i];
    }

    if (localSum > maxSum) {
      maxSum = localSum;
    }
  }

  return Math.max(maxSum, localSum);
};

describe('maxSubArray', () => {
  it('case 1', () => {
    expect(maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4])).toBe(6);
  });

  it('case 2', () => {
    expect(maxSubArray([1, 2, -1, 4])).toBe(6);
  });

  it('case 3 ', () => {
    expect(maxSubArray([1, 2, -1, 5])).toBe(7);
  });

  it('case 4', () => {
    expect(maxSubArray([-1, 2, 4, -1])).toBe(6);
  });

  it('case 5', () => {
    expect(maxSubArray([-10, 1, 1, -10, 1])).toBe(2);
  });

  it('case 6', () => {
    expect(maxSubArray([1])).toBe(1);
  });

  it('case 7', () => {
    expect(maxSubArray([-2, -1])).toBe(-1);
  });
});
