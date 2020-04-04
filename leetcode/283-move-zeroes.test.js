const swap = (A, i, j) => {
  const tmp = A[i];
  A[i] = A[j];
  A[j] = tmp;
};

const moveZeroes = (A) => {
  const n = A.length;
  let nonZeroIdx = 0;
  let zeroIdx = 0;

  while (nonZeroIdx < n) {
    while (A[nonZeroIdx] === 0) {
      nonZeroIdx += 1;
    }
    while (A[zeroIdx]) {
      zeroIdx += 1;
    }

    if (nonZeroIdx >= n || zeroIdx >= n) {
      break;
    }

    if (nonZeroIdx < zeroIdx) {
      nonZeroIdx += 1;
      continue;
    } else {
      swap(A, nonZeroIdx, zeroIdx);
    }
  }
  return A;
};

describe('moveZeroes', () => {
  it('case 1', () => {
    expect(moveZeroes([0, 1, 0, 3, 12])).toEqual([1, 3, 12, 0, 0]);
  });

  it('case 2', () => {
    expect(moveZeroes([2, 1])).toEqual([2, 1]);
  });

  it('case 3', () => {
    expect(moveZeroes([1, 0, 1, 0, 1])).toEqual([1, 1, 1, 0, 0]);
  });

  it('case 4', () => {
    expect(moveZeroes([1, 1, 1, 0, 0])).toEqual([1, 1, 1, 0, 0]);
  });

  it('case 5', () => {
    expect(moveZeroes([0, 0, 0, 1, 1])).toEqual([1, 1, 0, 0, 0]);
  });

  it('case 6', () => {
    expect(moveZeroes([1, 0, 1])).toEqual([1, 1, 0]);
  });
});
