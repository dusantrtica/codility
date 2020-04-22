// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
function BinaryMatrix(data) {
  this.data = data;

  this.get = function (x, y) {
    return this.data[x][y];
  };

  this.dimensions = function () {
    return [this.data.length, this.data[0].length];
  };
}

var leftMostColumnWithOne = function (binaryMatrix) {
  const [n, m] = binaryMatrix.dimensions();

  let column = m - 1;
  let row = 0;
  let found = false;
  while (row < n && column >= 0) {
    let currElem = binaryMatrix.get(row, column);
    if (currElem === 1) {
      found = true;
      column -= 1;
    } else {
      row += 1;
    }
  }

  return found ? column + 1 : -1;
};

describe('leftMostColumnWithOne', () => {
  it('case 1', () => {
    const binaryMatrix = new BinaryMatrix([
      [0, 0],
      [0, 1],
    ]);
    expect(leftMostColumnWithOne(binaryMatrix)).toBe(1);
  });

  it('case 2', () => {
    const binaryMatrix = new BinaryMatrix([
      [0, 0],
      [0, 0],
    ]);
    expect(leftMostColumnWithOne(binaryMatrix)).toBe(-1);
  });
});
