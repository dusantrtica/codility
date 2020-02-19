import { mergeSort, quickSort } from './sort';

describe('quickSort', () => {
  it('should sort properly empty array', () => {
    expect(quickSort([])).toEqual([]);
  });

  it('should sort properly one element array ', () => {
    expect(quickSort([1])).toEqual([1]);
  });

  it('should work for sorted array', () => {
    expect(quickSort([1, 2, 3, 4, 5])).toEqual([1, 2, 3, 4, 5]);
  });

  it('should work for reverse sorted array', () => {
    expect(quickSort([5, 4, 3, 2, 1])).toEqual([1, 2, 3, 4, 5]);
  });

  it('should sort random arrays', () => {
    expect(quickSort([4, 2, 3, 1, 5])).toEqual([1, 2, 3, 4, 5]);
    expect(quickSort([1, 1, 1, 1, 1])).toEqual([1, 1, 1, 1, 1]);
  });
  it('should work for even length array', () => {
    expect(quickSort([4, 3, 5, 1, 6, 2])).toEqual([1, 2, 3, 4, 5, 6]);
  });
});

describe('mergeSort', () => {
  it('should sort properly empty array', () => {
    expect(mergeSort([])).toEqual([]);
  });

  it('should sort properly one element array ', () => {
    expect(mergeSort([1])).toEqual([1]);
  });

  it('should work for sorted array', () => {
    expect(mergeSort([1, 2, 3, 4, 5])).toEqual([1, 2, 3, 4, 5]);
  });

  it('should work for reverse sorted array', () => {
    expect(mergeSort([5, 4, 3, 2, 1])).toEqual([1, 2, 3, 4, 5]);
  });

  it('should sort random arrays', () => {
    expect(mergeSort([4, 2, 3, 1, 5])).toEqual([1, 2, 3, 4, 5]);
    expect(mergeSort([1, 1, 1, 1, 1])).toEqual([1, 1, 1, 1, 1]);
  });
  it('should work for even length array', () => {
    expect(mergeSort([4, 3, 5, 1, 6, 2])).toEqual([1, 2, 3, 4, 5, 6]);
  });
});
