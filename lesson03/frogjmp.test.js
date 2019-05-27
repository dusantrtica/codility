import { frogJmp } from "./frogjmp";

describe("frogJmp", () => {
  it("should pass sanity test", () => {
    expect(frogJmp(10, 85, 30)).toBe(3);
  });

  it("should pass test 1", () => {
    expect(frogJmp(1, 10, 1)).toBe(9);
  });

  it("should pass test 2", () => {
    expect(frogJmp(1, 10, 2)).toBe(5);
  });

  it("should pass test 3", () => {
    expect(frogJmp(0, 10, 2)).toBe(5);
  });

  it("should work for the big Y", () => {
    expect(frogJmp(1, 1000000000, 1)).toBe(999999999);
  });
});
