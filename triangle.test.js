const isTriangular = (a, b, c) => a + b > c && a + c > b && c + b > a;

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)
  const n = A.length;
  if (n <= 2) {
    return 0;
  }
  A.sort((a, b) => a - b);
  for (let i = n - 1; i >= 2; i--) {
    if (isTriangular(A[i], A[i - 1], A[i - 2])) {
      return 1;
    }
  }

  return 0;
}

describe('solution', () => {
  it('case 1', () => {
    expect(solution([1])).toBe(0);
  });

  it('case 2', () => {});
});
