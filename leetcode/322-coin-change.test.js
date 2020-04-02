const coinChange = (coins, amount) => {
  const coinsCount = coins.length;
  const memo = Array(amount + 1).fill(amount + 1);
  memo[0] = 0;

  for (let i = 1; i < amount + 1; i++) {
    for (let j = 0; j < coinsCount; j++) {
      const coin = coins[j];
      if (i >= coin && memo[i - coin] + 1 < memo[i]) {
        memo[i] = memo[i - coin] + 1;
      }
    }
  }

  return memo[amount] > amount ? -1 : memo[amount];
};

describe('coinChange', () => {
  it('case 1', () => {
    expect(coinChange([1, 2, 5], 11)).toBe(3);
  });

  it('case 2', () => {
    expect(coinChange([1, 2], 5)).toBe(3);
  });
});
