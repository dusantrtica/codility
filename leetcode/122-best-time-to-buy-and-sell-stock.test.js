const maxProfit = (A) => {
  let profit = 0;
  const n = A.length;
  let bought = false;
  let lastBoughtStockPrice = A[0];
  for (let i = 0; i < n - 1; i++) {
    if (A[i] > A[i + 1]) {
      if (bought) {
        bought = false;
        profit += A[i] - lastBoughtStockPrice;
      }
    } else if (A[i] < A[i + 1]) {
      if (!bought) {
        bought = true;
        lastBoughtStockPrice = A[i];
      }
    }
  }

  if (bought) {
    profit += A[n - 1] - lastBoughtStockPrice;
  }
  return profit;
};

describe('maxProfit', () => {
  it('case 1', () => {
    expect(maxProfit([5, 4, 3, 2, 1])).toBe(0);
  });

  it('case 2', () => {
    expect(maxProfit([7, 1, 5, 3, 6, 4])).toBe(7);
  });

  it('case 3', () => {
    expect(maxProfit([1, 2, 3, 4, 5])).toBe(4);
  });
});
