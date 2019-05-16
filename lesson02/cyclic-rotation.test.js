import { rotate } from "./cyclic-rotation";

describe("cyclic-rotation", () => {
  it("should handle the case where k == 0", () => {
    expect(rotate([3, 4, 5], 0)).toEqual([3, 4, 5]);
  });
  it("should not rotate one element array", () => {
    expect(rotate([2], 0)).toEqual([2]);
    expect(rotate([2], 1)).toEqual([2]);
    expect(rotate([2], 2)).toEqual([2]);
    expect(rotate([2], 3)).toEqual([2]);
  });

  it("should rotate 2 element array", () => {
    expect(rotate([2, 6], 1)).toEqual([6, 2]);
    expect(rotate([2, 6], 2)).toEqual([2, 6]);
    expect(rotate([2, 6], 3)).toEqual([6, 2]);
  });

  it("shoudl rotate 3 elements array", () => {
    expect(rotate([3, 5, 9], 1)).toEqual([9, 3, 5]);
    expect(rotate([3, 5, 9], 2)).toEqual([5, 9, 3]);
    expect(rotate([3, 5, 9], 3)).toEqual([3, 5, 9]);
    // expect(rotate([3, 5, 9], 4)).toEqual([9, 3, 5]);
  });

  it("should work properly for 1 st test case", () => {
    expect(rotate([1, 2, 3, 4], 4)).toEqual([1, 2, 3, 4]);
  });

  it("should work properly for 2nd test case", () => {
    expect(rotate([3, 8, 9, 7, 6], 3)).toEqual([9, 7, 6, 3, 8]);
  });
});
