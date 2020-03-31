const maxProductOfThreeBF = (A) => {
  const n = A.length;
  let sum = Number.MIN_SAFE_INTEGER;

  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      for (let k = j + 1; j < n; j++) {
        if (i !== j && j !== k && i !== k && A[i] * A[j] * A[k] > sum) {
          sum = A[i] * A[j] * A[k];
        }
      }
    }
  }

  return sum || 0; // because of -0;
};

const maxProductOfThree = (A) => {
  const n = A.length;
  A.sort();
  return Math.max(A[0] * A[1] * A[n - 1], A[n - 1] * A[n - 2] * A[n - 3]);
};

const solution = maxProductOfThree;

describe('maxProductOfThree', () => {
  it('case 1', () => {
    expect(solution([1, 2, 3])).toBe(6);
  });

  it('case 2', () => {
    expect(solution([1, 0, 2, 3])).toBe(6);
  });

  it('case 3 ', () => {
    expect(solution([-1, 2, 3, 0])).toBe(0);
  });

  it('case 4, ', () => {
    expect(solution([-1, 2, 3, -1])).toBe(3);
  });

  it('case 5', () => {
    const A = [];
    A[0] = -3;
    A[1] = 1;
    A[2] = 2;
    A[3] = -2;
    A[4] = 5;
    A[5] = 6;

    expect(solution(A)).toBe(60);
  });
});
