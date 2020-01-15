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
const missingInteger = (A) => {
    let currMin = 1;
    const addedNumbers = {};
    const n = A.length;
    for (var i = 0; i < n; i++) {
      const currElem = A[i];
      if(currElem === curMin) {
        curMin += 1;
        addedNumbers[currElem] = true;
      }
    }

    return currMin;
}

export default missingInteger;
