import { permCheck } from "./permcheck";
describe("permCheck", () => {
  it("should return true if A contains only 1", () => {
    expect(permCheck([1])).toBe(true);
  });

  it("should return false if A contains only 2", () => {
    expect(permCheck([2])).toBe(false);
    expect(permCheck([0])).toBe(false);
  });

  it("should return true if A contains 3 (1,2,3) elements in any order", () => {
    expect(permCheck([1, 2, 3])).toBe(true);
    expect(permCheck([2, 3, 1])).toBe(true);
    expect(permCheck([3, 2, 1])).toBe(true);
    expect(permCheck([2, 1, 3])).toBe(true);
  });

  it("should return false if A contains 3 elements which are not 1,2,3", () => {
    expect(permCheck([4, 1, 2])).toBe(false);
    expect(permCheck([4, 5, 2])).toBe(false);
    expect(permCheck([1, 0, 2])).toBe(false);
    expect(permCheck([4, 2, 2])).toBe(false);
    expect(permCheck([5, 1, 0])).toBe(false);
  });

  it("should return true if one element appears twice", () => {
    expect(permCheck([1, 1, 2])).toBe(false);
  });
});
