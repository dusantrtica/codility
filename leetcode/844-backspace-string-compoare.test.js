const backspaceCompare_ = (s, t) => {
  const sLen = s.length;
  const tLen = t.length;

  let i = sLen - 1;
  let j = tLen - 1;

  while (i >= 0 && j >= 0) {
    let sHashCount = 0;
    let tHashCount = 0;
    while (s[i] === '#') {
      i--;
      sHashCount += 1;
    }
    i -= sHashCount;

    while (t[j] === '#') {
      j--;
      tHashCount += 1;
    }
    j -= tHashCount;

    if (i < 0 && j < 0) {
      break;
    }

    if (s[i] !== t[j]) {
      return false;
    }
    j--;
    i--;
  }

  return true;
};

const backspaceCompare = (s, t) => {
  const sArr = [];
  const tArr = [];
  const sLen = s.length;
  const tLen = t.length;

  for (let i = 0; i < sLen; i++) {
    if (s[i] === '#') {
      sArr.pop();
    } else {
      sArr.push(s[i]);
    }
  }

  for (let j = 0; j < tLen; j++) {
    if (t[j] === '#') {
      tArr.pop();
    } else {
      tArr.push(t[j]);
    }
  }

  return sArr.toString() === tArr.toString();
};

describe('backspaceCompoare', () => {
  it('case 1', () => {
    expect(backspaceCompare('ab#c', 'ad#c')).toBe(true);
  });

  it('case 2', () => {
    expect(backspaceCompare('ab##', 'c#d#')).toBe(true);
  });

  it('case 3', () => {
    expect(backspaceCompare('a##c', '#a#c')).toBe(true);
  });

  it('case 4', () => {
    expect(backspaceCompare('a#c', 'b')).toBe(false);
  });
});
