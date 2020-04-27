var maximalSquare = function (matrix) {
  const n = matrix.length;
  const m = matrix[0] ? matrix[0].length : 0;
  if (!m || !n) {
    return 0;
  }

  let longestEdge = 0;
  const memo = Array(n).fill(0);
  for (let i = 0; i < n; i++) {
    memo[i] = Array(m).fill(0);
  }

  for (let i = 0; i < n; i++) {
    memo[i][0] = matrix[i][0];
    longestEdge = Math.max(longestEdge, matrix[i][0]);
  }

  for (let j = 0; j < m; j++) {
    memo[0][j] = matrix[0][j];
    longestEdge = Math.max(longestEdge, matrix[0][j]);
  }

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      if (matrix[i][j] == 1) {
        memo[i][j] =
          Math.min(memo[i - 1][j - 1], memo[i - 1][j], memo[i][j - 1]) + 1;
        if (longestEdge < memo[i][j]) {
          longestEdge = memo[i][j];
        }
      }
    }
  }

  return longestEdge * longestEdge;
};

describe('maximalSquare', () => {
  it('case 1', () => {
    expect(
      maximalSquare([
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0'],
      ]),
    ).toBe(4);
  });
  it('case 2', () => {
    expect(maximalSquare([['1']])).toBe(1);
  });
});
