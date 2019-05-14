import { binaryGap } from "./";

describe("binaryGap", () => {
  it("should return 0 for 1", () => {
    expect(binaryGap(1)).toBe(0);
  });

  it("should return binary gap for number 32", () => {
    expect(binaryGap(32)).toBe(0);
  });

  it("should return binary gap for number 0", () => {
    expect(binaryGap(0)).toBe(0);
  });

  it("should return binary gap for number 15", () => {
    expect(binaryGap(15)).toBe(0);
  });

  it("should return binary gap for numbe 3", () => {
    expect(binaryGap(3)).toBe(0);
  });
  it("should return binary gap for number 24", () => {
    expect(binaryGap(24)).toBe(0);
  });
  it("should return binary gap for number 5", () => {
    expect(binaryGap(5)).toBe(1);
  });
  it("should return binary gap for number 17", () => {
    expect(binaryGap(17)).toBe(3);
  });
  it("should return binary gap for number 9", () => {
    expect(binaryGap(9)).toBe(2);
  });
  it("should return binary gap for number 529", () => {
    expect(binaryGap(529)).toBe(4);
  });
  it("should return binary gap for number 1041", () => {
    expect(binaryGap(1041)).toBe(5);
  });

  it("should return binary gap for number 20", () => {
    expect(binaryGap(20)).toBe(1);
  });
});
