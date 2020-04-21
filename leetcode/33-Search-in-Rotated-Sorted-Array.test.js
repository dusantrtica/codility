const binarySearch = (nums, target, start = 0, end = nums.length - 1) => {
  if (start > end) return -1;

  let mid = Math.floor((start + end) / 2);

  if (nums[mid] === target) return mid;

  if (nums[mid] > target) return binarySearch(nums, target, start, mid - 1);
  else return binarySearch(nums, target, mid + 1, end);
};
const binarySearchRotated = (nums, target, start, end) => {
  let mid = Math.floor((start + end) / 2);
  const midElem = nums[mid];
  const startElem = nums[start];
  const endElem = nums[end];

  if (start === end) {
    return nums[start] === target ? start : -1;
  }

  // Kad podelimo niz na pola, uvek je jedna polovina sortirana
  // tu radimo binary search ako je to ta polovina
  if (nums[start] <= nums[mid]) {
    if (startElem <= target && target <= midElem) {
      return binarySearch(nums, target, start, mid);
    } else {
      return binarySearchRotated(nums, target, mid + 1, end);
    }
  } else if (nums[mid] <= nums[end]) {
    if (midElem <= target && target <= endElem) {
      return binarySearch(nums, target, mid, end);
    } else {
      return binarySearchRotated(nums, target, start, mid);
    }
  }
};

const search = (nums, target) => {
  const n = nums.length;

  return binarySearchRotated(nums, target, 0, n - 1);
};

describe('search', () => {
  describe('binarySearch', () => {
    it('case 1', () => {
      expect(binarySearch([1, 2, 3, 4, 5], 3)).toBe(2);
    });
    it('case 2', () => {
      expect(binarySearch([1, 2, 3, 4, 5], 5)).toBe(4);
    });
    it('case 3', () => {
      expect(binarySearch([1, 2, 3, 4, 5], 1)).toBe(0);
    });
    it('case 4', () => {
      expect(binarySearch([], 1)).toBe(-1);
    });
    it('case 5', () => {
      expect(binarySearch([1], 1)).toBe(0);
    });
    it('case 6', () => {
      expect(binarySearch([1, 2, 3, 4, 5, 6], 6)).toBe(5);
      expect(binarySearch([1, 2, 3, 4, 5, 6], 5)).toBe(4);
    });
  });
  it('case 1', () => {
    expect(search([4, 5, 6, 7, 0, 1, 2], 0)).toBe(4);
  });

  it('case 2', () => {
    expect(search([4, 5, 6, 7, 0, 1, 2], 3)).toBe(-1);
  });

  it('case 3', () => {
    expect(search([1], 1)).toBe(0);
  });

  it('case 4', () => {
    expect(search([1, 3], 1)).toBe(0);
  });

  it('case 5', () => {
    expect(search([3, 1], 1)).toBe(1);
  });
});
