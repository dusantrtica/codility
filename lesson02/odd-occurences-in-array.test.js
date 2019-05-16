import { solution } from "./odd-occurences-in-array";

describe("odd-occurences-in-array", () => {
  it("should return 1st element if array contains one element", () => {
    expect(solution([4])).toBe(4);
  });

  it("should return element that appears 1 time in 3len array", () => {
    expect(solution([1, 1, 3])).toBe(3);
  });

  it("should return element that appears 3 times in 3 len array", () => {
    expect(solution([3, 3, 3])).toBe(3);
  });

  it("should return element that appears 1 time on 7 len array", () => {
    expect(solution([9, 3, 9, 3, 9, 7, 9])).toBe(7);
  });
});
