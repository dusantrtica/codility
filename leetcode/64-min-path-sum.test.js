const minPathSum = (grid) => {
  const n = grid.length;
  const m = grid[0].length;

  const cost = Array(n).fill(0);
  for (let i = 0; i < n; i++) {
    cost[i] = Array(m).fill(0);
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (i === 0) {
        if (j === 0) {
          cost[i][j] = grid[i][j];
        } else {
          cost[i][j] = cost[i][j - 1] + grid[i][j];
        }
      } else if (j === 0) {
        cost[i][j] = cost[i - 1][j] + grid[i][j];
      } else {
        const upper = cost[i - 1][j];
        const left = cost[i][j - 1];

        cost[i][j] = Math.min(upper, left) + grid[i][j];
      }
    }
  }

  return cost[n - 1][m - 1];
};

describe('minPathSum', () => {
  it('case 1', () => {
    expect(
      minPathSum([
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1],
      ]),
    ).toBe(7);
  });

  it('case 2', () => {
    expect(
      minPathSum([
        [1, 2],
        [3, 4],
      ]),
    ).toBe(7);
  });

  it('case 3', () => {
    expect(minPathSum([[1]])).toBe(1);
  });

  it('case 4', () => {
    expect(
      minPathSum([
        [1, 5],
        [4, 3],
      ]),
    ).toBe(8);
  });
});
