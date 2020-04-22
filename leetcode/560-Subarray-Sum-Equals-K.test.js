const subarraySum = (A, k) => {
  const n = A.length;
  // sum(i, j) = sum(j, 0) - sum(i, 0)
  let sum = (i, j) => sums[j] - sums[i];
  let s = 0;
  const sums = Array(n);
  for (let i = 0; i < n; i++) {
    s = s + A[i];
    sums[i] = s;
  }
  let i = 0;
  let j = 1;
  let kSumsCount = 0;
  let localSum = A[0];

  let loopCnt = 0; // tmp;
  while (i < n || j < n) {
    loopCnt += 1;
    if (loopCnt > 100) {
      break;
    }
    if (Math.abs(k - A[j]) < Math.abs(k - localSum + A[j])) {
      localSum = A[j];
      i += 1;
    } else {
      localSum += A[j];
      j += 1;
    }

    if (localSum === k) {
      kSumsCount += 1;
    }
  }

  return kSumsCount;
};

describe('subarraySum', () => {
  it('case 1', () => {
    expect(subarraySum([1, 1, 1], 2)).toBe(2);
  });
  it('case 2', () => {
    expect(subarraySum([1, 1, 1], 3)).toBe(1);
  });
  it('case 3', () => {
    expect(subarraySum([1, 1, 1, 2, 1, 1], 2)).toBe(4);
  });
  it('case 4', () => {
    expect(subarraySum([1, 1, 1, 2, 1, 1], 3)).toBe(3);
  });
});
