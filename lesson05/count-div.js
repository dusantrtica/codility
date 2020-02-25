export const bruteForceCountDiv = (a, b, k) => {
  let divisableElemsCount = 0;
  for (let i = a; i <= b; i++) {
    if (i % k === 0) {
      divisableElemsCount += 1;
    }
  }

  return divisableElemsCount;
};

export const countDivKSteps = (a, b, k) => {
  let divisableElemsCount = 0;
  let start;
  if (a % k === 0) {
    start = a;
  } else {
    start = a + Math.abs(a - k);
  }
  while (start <= b) {
    divisableElemsCount += 1;
    start += k;
  }

  return divisableElemsCount;
};

export const countDivConstant = (a, b, k) => {
  let numDivisorsToB = Math.floor(b / k);
  const numDivisorsToA = a > 0 ? Math.floor((a - 1) / k) : 0;
  if (a === 0) {
    numDivisorsToB += 1;
  }
  return numDivisorsToB - numDivisorsToA;
};

export const countDiv = countDivConstant;
