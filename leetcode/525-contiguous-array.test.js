const findMaxLength = (A) => {
  const n = A.length;
  const B = Array(n);
  let sum = 0;
  for (let i = 0; i < n; i++) {
    let curr = A[i] || -1;
    sum += curr;
    B[i] = sum;
  }

  let longestDistance = 0;
  const seenElementsAndTheirIndexes = {};
  for (let i = 0; i < n; i++) {
    let currElem = B[i];
    if (currElem === 0) {
      longestDistance = Math.max(longestDistance, i + 1);
    } else {
      if (seenElementsAndTheirIndexes[currElem] !== undefined) {
        if (i - seenElementsAndTheirIndexes[currElem] >= longestDistance) {
          longestDistance = i - seenElementsAndTheirIndexes[currElem];
        }
      } else {
        seenElementsAndTheirIndexes[currElem] = i;
      }
    }
  }
  return longestDistance;
};

describe('findMaxLength', () => {
  it('case 1', () => {
    expect(findMaxLength([0, 1])).toBe(2);
  });

  it('case 2', () => {
    expect(findMaxLength([0, 1, 0])).toBe(2);
  });

  it('case 3', () => {
    expect(findMaxLength([0, 0, 1, 0, 0, 0, 1, 1])).toBe(6);
  });
});
