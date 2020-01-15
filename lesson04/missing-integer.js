/**
 * 
 This is a demo task.

Write a function:

function solution(A);

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

/**
 * 
 Solution. First we replace negative values with zeroes.
 Then, we sort array. This gives us A[0] to be the smallest element
 Then we iterate through A, and at each iteration we check if 2 consecutive
 elements A[i-1], A[i] differs for 1. If that is not the case, (e.g: 4, 6), then
 A[i-1] + 1 is the smallest element that is not in array
 Special case is when 
 */

/**
 * Solution:
 * Suppose that we sort array A. Then, iterating through sorted A, if there are 2 elements
 * such are their difference is more than 1,A[i-1], A[i], then A[i-1] + 1 is the desired number.
 * This means that desired number is in range [1, A.length].
 * If A does not contain number 1, then 1 is our number. If A contains number 1, then next candidate is 2.
 * If A does not contain 2, 2 is our number. If it contains 2, then 3 is our next candidate. And so on.
 * So if A does not contain N, then N is our number, otherwise it is N + 1.
 * This means that if A contain all the numbers from 1 to N, N + 1 is our number (len(A) = N)
 * If there is a number from 1 to N that is not in A , say that is X, then X is our element.
 */
const missingInteger1 = (A) => {
  const B = {};
  const n = A.length;
  let i;
  for (i = 0; i < n; i++) {
    const elem = A[i];
    if (elem > 0) {
      B[elem] = true;
    }
  }

  for (i = 1; i <= n; i++) {
    if (!B[i]) {
      return i;
    }
  }

  return i;
}

const missingInteger = (A) => {
  A.sort((a, b) => (a - b));
  const B = A.map(elem => elem > 0 ? elem : 0);
  if (B[0] > 1) {
    return 1;
  }

  var i;
  const n = B.length;
  for (i = 1; i < n; i++) {
    if (Math.abs(B[i] - B[i - 1]) > 1) {
      return B[i - 1] + 1;
    }
  }

  return B[n - 1] + 1;
}

export default missingInteger;
