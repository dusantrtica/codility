const minAvgSliceBruteForce = (A) => {
  const n = A.length;
  let minAvg = Number.MAX_SAFE_INTEGER;
  let minAvgIndex = 0;
  for (let i = 0; i < n; i++) {
    let avg = 0;
    let currSum = A[i];
    for (let j = i + 1; j < n; j++) {
      currSum += A[j];
      avg = currSum / (j - i + 1);
      if (avg < minAvg) {
        minAvg = avg;
        minAvgIndex = i;
      }
    }
  }
  return minAvgIndex;
};

// we only need to check slices of size 2 or 3;
const minAvgSlice = (A) => {
  const n = A.length;
  let minAvg = Number.MAX_SAFE_INTEGER;
  let minAvgIndex = 0;

  for (let i = 0; i < n - 1; i++) {
    if (A[i] + A[i + 1] / 2 < minAvg) {
      minAvg = A[i] + A[i + 1] / 2;
      minAvgIndex = i;
    }

    if (i < n - 2 && (A[i] + A[i + 1] + A[i + 2]) / 3 < minAvg) {
      minAvg = (A[i] + A[i + 1] + A[i + 2]) / 3;
      minAvgIndex = i;
    }
  }

  return minAvgIndex;
};

const minAvgSliceKadan = (A) => {
  const n = A.length;
  let minAvgIndex = 0;
  let minAvg = (A[0] + A[1]) / 2;
  let currSum = A[0];
  let localMinAvg = Number.MAX_SAFE_INTEGER;
  let localMinAvgIndex = 0;
  if (n === 2) {
    return 0;
  }
  for (let i = 1; i < n; i++) {
    currSum += A[i];
    let currLastTwoAvg = (A[i] + A[i - 1]) / 2;
    let currAvgWithAllPrevious = currSum / (i - localMinAvgIndex + 1);

    if (currLastTwoAvg < localMinAvg) {
      localMinAvg = currLastTwoAvg;
      localMinAvgIndex = i - 1;
      currSum = A[i - 1] + A[i];
    } else {
      localMinAvg = currAvgWithAllPrevious;
    }

    if (localMinAvg < minAvg) {
      minAvg = localMinAvg;
      minAvgIndex = localMinAvgIndex;
    }
  }

  return minAvgIndex;
};

export default minAvgSliceKadan;
