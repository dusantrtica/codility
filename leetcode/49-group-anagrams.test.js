// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
// 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
// 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199
const lettersToPrimeNumbers = {
  a: 2,
  b: 3,
  c: 5,
  d: 7,
  e: 11,
  f: 13,
  g: 19,
  h: 23,
  i: 29,
  j: 31,
  k: 37,
  l: 41,
  m: 43,
  n: 47,
  o: 53,
  p: 59,
  q: 61,
  r: 67,
  s: 71,
  t: 73,
  u: 79,
  v: 83,
  w: 89,
  x: 97,
  y: 101,
  z: 103,
};

const groupAnagrams = (strs) => {
  const wordsMap = {};
  const n = strs.length;

  for (let i = 0; i < n; i++) {
    const word = strs[i];
    const charMul = [...word]
      .map((char) => lettersToPrimeNumbers[char])
      .reduce((curr, acc) => curr * acc, 1);

    if (wordsMap[charMul]) {
      wordsMap[charMul].push(word);
    } else {
      wordsMap[charMul] = [word];
    }
  }

  return Object.values(wordsMap);
};

describe('groupAnagrams', () => {
  it('case 1', () => {
    expect(groupAnagrams(['abc', 'cba'])).toEqual([['abc', 'cba']]);
  });

  it('case 2', () => {
    expect(groupAnagrams(['eat', 'ate', 'tan', 'tea'])).toEqual([
      ['eat', 'ate', 'tea'],
      ['tan'],
    ]);
  });
});
