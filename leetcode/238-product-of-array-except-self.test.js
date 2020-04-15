const productExceptSelf = (A) => {
  const n = A.length;
  const prefixProd = Array(n).fill(1);
  const suffixProd = Array(n).fill(1);

  const result = Array(n);

  for (let i = 0; i < n - 1; i++) {
    prefixProd[i + 1] = prefixProd[i] * A[i];
  }

  for (let i = n - 1; i > 0; i--) {
    suffixProd[i - 1] = suffixProd[i] * A[i];
  }

  for (let i = 0; i < n; i++) {
    result[i] = suffixProd[i] * prefixProd[i];
  }

  return result;
};

describe('productExceptSelf', () => {
  it('case 1', () => {
    expect(productExceptSelf([1, 2, 3, 4])).toEqual([24, 12, 8, 6]);
  });
});
