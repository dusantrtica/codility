import { permMissingElement } from "./permmissingelem";

describe("permMissingElement", () => {
  it("should return 1 in zero elements array", () => {
    expect(permMissingElement([])).toBe(1);
  });

  it("should return 2 in two elements array", () => {
    expect(permMissingElement([2])).toBe(1);
  });

  it("should return 3 in three elements array", () => {
    expect(permMissingElement([3, 1])).toBe(2);
  });

  it("the order should not matter", () => {
    expect(permMissingElement([1, 3])).toBe(2);
  });

  it("should return return 4 for givent test case", () => {
    expect(permMissingElement([2, 3, 1, 5])).toBe(4);
  });

  it("should find missing element in 5 elements array", () => {
    expect(permMissingElement([2, 4, 1, 6, 3])).toBe(5);
  });
});
