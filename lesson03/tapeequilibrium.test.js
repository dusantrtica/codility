import { tapeEquilibrium } from "./tapeequilibrium";

describe("tapeEquilibrium", () => {
  it("should work fine for 2 elements array", () => {
    expect(tapeEquilibrium([0, 1])).toBe(1);
    expect(tapeEquilibrium([0, 0])).toBe(0);
    expect(tapeEquilibrium([10, 3])).toBe(7);
  });

  it("should pass test case 1", () => {
    expect(tapeEquilibrium([1, 2, 3])).toBe(0);
  });

  it("should pass test case 2", () => {
    expect(tapeEquilibrium([5, 2, 8])).toBe(1);
  });

  it("should pass test case 3 ", () => {
    expect(tapeEquilibrium([4, 3, 1, 2, 4])).toBe(0);
  });

  it("should pass test case 4 (assignment test case)", () => {
    expect(tapeEquilibrium([3, 1, 2, 4, 3])).toBe(1);
  });
});
