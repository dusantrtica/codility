const _minCostClimbingStairs = (cost, i) => {
  if (i < 0) {
    return 0;
  }
  if (i === 0) {
    return cost[i];
  }
  return Math.min(
    cost[i] + _minCostClimbingStairs(cost, i - 1),
    cost[i] + _minCostClimbingStairs(cost, i - 2),
  );
};
const minCostClimbingStairsRec = (cost) => {
  return _minCostClimbingStairs(cost, cost.length - 1);
};

const minCostClimbingStairsDP = (cost) => {
  const n = cost.length;
  const memo = Array(n).fill(0);

  memo[0] = cost[0];
  memo[1] = cost[1];

  for (let i = 2; i < n; i++) {
    memo[i] = Math.min(memo[i - 1], memo[i - 2]) + (i === n ? 0 : cost[i]);
  }

  console.log({ memo });
  return memo[memo.length - 1];
};

const minCostClimbingStairs = minCostClimbingStairsDP;

describe('minCostClimbingStairs', () => {
  it('case 1', () => {
    expect(minCostClimbingStairs([10, 15, 20])).toBe(25);
  });

  it('case 2', () => {
    expect(minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])).toBe(6);
  });
  it('sanity case', () => {
    expect(minCostClimbingStairs([10, 20])).toBe(10);
    expect(minCostClimbingStairs([20, 10])).toBe(10);
  });

  it('case 4', () => {
    expect(minCostClimbingStairs([0, 0, 1, 1])).toBe(1);
  });
});
