var longestCommonSubsequence = function (text1, text2) {
  const n = text1.length;
  const m = text2.length;

  const lcs = Array(n + 1).fill(0);
  for (let i = 0; i <= n; i++) {
    lcs[i] = Array(m + 1).fill(0);
  }

  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= m; j++) {
      if (text1[i - 1] === text2[j - 1]) {
        console.log('equal chars ', i, j);
        lcs[i][j] = lcs[i - 1][j - 1] + 1;
      } else {
        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
      }
    }
  }

  return lcs[n][m];
};

describe('longestCommonSubsequence', () => {
  it('case 1', () => {
    expect(
      longestCommonSubsequence(
        'lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva',
        'bklgfivmpozinybwlovcnafqfybodkhabyrglsnen',
      ),
    ).toBe(9);
  });

  it('case 2', () => {
    expect(longestCommonSubsequence('abc', 'def')).toBe(0);
  });
});
