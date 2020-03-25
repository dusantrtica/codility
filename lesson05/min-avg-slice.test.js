import minAvgSlice from './min-avg-slice';

describe('minAvgSlice', () => {
  it('case 1', () => {
    expect(minAvgSlice([1, 2])).toBe(0);
  });

  it('case 2', () => {
    expect(minAvgSlice([4, 1, 2])).toBe(1);
  });

  it('case 3', () => {
    expect(minAvgSlice([2, 1, 1, 1])).toBe(1);
  });

  it('case 4', () => {
    expect(minAvgSlice([4, 2, 2, 5, 1, 5, 8])).toBe(1);
  });
});
