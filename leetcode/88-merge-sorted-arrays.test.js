const mergeInPlace = (nums1, m, nums2, n) => {
  let totalLen = n + m;
  let i = m - 1;
  let j = n - 1;
  while (totalLen >= 0) {
    const curr1 = nums1[i];
    const curr2 = nums2[j];

    if (curr1 >= curr2 || curr2 === undefined) {
      nums1[totalLen - 1] = curr1;
      i--;
    } else {
      nums1[totalLen - 1] = curr2;
      j--;
    }

    totalLen -= 1;
  }
};

describe('mergeInPlace', () => {
  it('case 1', () => {
    let a = [1];
    let b = [];
    mergeInPlace(a, 1, b, 0);
    expect(a).toEqual([1]);

    a = [];
    b = [1];
    mergeInPlace(a, 0, b, 1);
    expect(a).toEqual([1]);
  });
  it('case 2', () => {
    const a = [1, 0];
    const b = [1];
    mergeInPlace(a, 1, b, 1);
    expect(a).toEqual([1, 1]);
  });
  it('case 3', () => {
    let a = [1, 0];
    let b = [2];
    mergeInPlace(a, 1, b, 1);
    expect(a).toEqual([1, 2]);

    a = [2, 0];
    b = [1];
    mergeInPlace(a, 1, b, 1);
    expect(a).toEqual([1, 2]);
  });
  it('case 4 ', () => {
    let a = [1, 3, 0, 0];
    let b = [2, 4];
    mergeInPlace(a, 2, b, 2);
    expect(a).toEqual([1, 2, 3, 4]);

    a = [2, 4, 0, 0];
    b = [1, 3];

    mergeInPlace(a, 2, b, 2);
    expect(a).toEqual([1, 2, 3, 4]);
  });

  it('case 5', () => {
    let a = [1, 2, 3, 0, 0];
    let b = [4, 5];

    mergeInPlace(a, 3, b, 2);
    expect(a).toEqual([1, 2, 3, 4, 5]);

    a = [4, 5, 0, 0, 0];
    b = [1, 2, 3];
    mergeInPlace(a, 2, b, 3);
    expect(a).toEqual([1, 2, 3, 4, 5]);
  });
  it('case 6', () => {
    let a = [1, 3, 5, 0, 0, 0];
    let b = [2, 4, 6];

    mergeInPlace(a, 3, b, 3);
    expect(a).toEqual([1, 2, 3, 4, 5, 6]);

    a = [2, 4, 6, 0, 0, 0];
    b = [1, 3, 5];
    mergeInPlace(a, 3, b, 3);
    expect(a).toEqual([1, 2, 3, 4, 5, 6]);
  });
  it('case 7', () => {
    const a = [-1, -1, 0, 0, 0, 0];
    const b = [-1, 0];
    mergeInPlace(a, 4, b, 2);
    expect(a).toEqual([-1, -1, -1, 0, 0, 0]);
  });
});
