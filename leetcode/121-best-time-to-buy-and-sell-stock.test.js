const maxProfit = (prices) => {
  let low = prices[0];
  let high = prices[1];
  const n = prices.length;
  let diff = high - low;

  for (let i = 2; i < n - 1; i++) {
    if (prices[i] < low) {
      low = prices[i];
      high = prices[i + 1];
    }

    if (prices[i + 1] > high) {
      high = prices[i + 1];
    }
    console.log({ low, high });
  }

  return high - low < 0 ? 0 : high - low;
};

describe('maxProfit', () => {
  it('case 1', () => {
    expect(maxProfit([6, 5, 3, 1])).toBe(0);
  });

  it('case 2', () => {
    expect(maxProfit([7, 1, 5, 3, 6, 4])).toBe(5);
  });
});
