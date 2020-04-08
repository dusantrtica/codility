const countElements = (A) => {
  //   const elementsMap = [];
  //   const n = A.length;
  //   for (let i = 0; i < n; i++) {
  //     const currElem = A[i];
  //     elementsMap[currElem] = (elementsMap[currElem] || 0) + 1;
  //   }

  //   let count = 0;
  //   for (let i = 0; i < elementsMap.length - 1; i++) {
  //     if (elementsMap[i + 1]) {
  //       count += elementsMap[i] || 0;
  //     }
  //   }

  //   return count;

  const elements = new Set();
  const n = A.length;
  let count = 0;
  for (let i = 0; i < n; i++) {
    elements.add(A[i]);
  }

  for (let i = 0; i < n; i++) {
    let curr = A[i];
    if (elements.has(curr + 1)) {
      count += 1;
    }
  }

  return count;
};

describe('countElements', () => {
  it('case 1', () => {
    expect(countElements([1, 2, 3])).toBe(2);
  });

  it('case 2', () => {
    expect(countElements(1, 1, 3, 3, 5, 5, 7, 7)).toBe(0);
  });

  it('case 3', () => {
    expect(countElements([1, 3, 2, 3, 5, 0])).toBe(3);
  });

  it('case 4', () => {
    expect(countElements([1, 1, 2, 2])).toBe(2);
  });
});
