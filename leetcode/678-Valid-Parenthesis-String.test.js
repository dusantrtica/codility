const checkValidString = (s) => {
  let counter = 0;
  let asterix = 0;
  const n = s.length;

  if (s[0] === ')' || s[n - 1] === '(') {
    return false;
  }

  for (let i = 0; i < n; i++) {
    const curr = s[i];
    if (curr === '(') {
      counter += 1;
    } else if (curr === ')') {
      counter -= 1;
    } else {
      asterix += 1;
    }
  }

  if (counter === 0) {
    return true;
  }

  if (counter < 0 && counter + asterix < 0) {
    return false;
  }

  if (counter > 0 && counter - asterix > 0) {
    return false;
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
});
