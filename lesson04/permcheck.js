export const permCheck = A => {
  const n = A.length;

  const numbers = {};

  for (let i = 0; i < n; i++) {
    const currElem = A[i];
    if (currElem > n || currElem < 1) {
      return false;
    }

    if (numbers[currElem]) {
      return false;
    }

    numbers[currElem] = true;
  }

  return Object.keys(numbers).length === n;
};
