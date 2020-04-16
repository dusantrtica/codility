const checkValidString = (s) => {
  let open = 0;
  let close = 0;
  let asterisk = 0;
  const n = s.length;

  for (let i = 0; i < n; i++) {
    const curr = s[i];
    if (curr === '(') {
      open += 1;
    } else if (curr === ')') {
      close += 1;
    } else {
      asterisk += 1;
    }
    if (open + asterisk < close) {
      return false;
    }
  }

  open = 0;
  asterisk = 0;
  close = 0;

  for (let i = n - 1; i >= 0; i--) {
    const curr = s[i];
    if (curr === ')') {
      close += 1;
    } else if (curr === '(') {
      open += 1;
    } else {
      asterisk += 1;
    }

    if (open > close + asterisk) {
      return false;
    }
  }

  return true;
};

describe('checkValidString', () => {
  it('case 1', () => {
    expect(checkValidString('()')).toBe(true);
  });

  it('case 2', () => {
    expect(checkValidString('(*)')).toBe(true);
  });

  it('case 3', () => {
    expect(checkValidString('(*))')).toBe(true);
  });

  it('case 4', () => {
    expect(checkValidString('(*)))')).toBe(false);
  });

  it('case 5', () => {
    expect(checkValidString('((*)')).toBe(true);
  });

  it('case 6', () => {
    expect(checkValidString(')(')).toBe(false);
  });

  it('case 7', () => {
    expect(
      checkValidString('(())((())()()(*)(*()(())())())()()((()())((()))(*'),
    ).toBe(false);
  });

  it('case 8', () => {
    expect(checkValidString('(')).toBe(false);
  });

  it('case 9', () => {
    expect(checkValidString('*')).toBe(true);
  });

  it('case 10', () => {
    expect(checkValidString('')).toBe(true);
  });
});
