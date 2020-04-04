const moveZeroes = (A) => {
  return A;
};

describe('moveZeroes', () => {
  it('case 1', () => {
    expect(moveZeroes([0, 1, 0, 3, 12])).toEqual([1, 3, 12, 0, 0]);
  });

  it('case 2', () => {
    expect(moveZeroes([2, 1])).toEqual([2, 1]);
  });
});
