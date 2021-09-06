package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class GuessGame {

  private int pick;

  public void setPick(int pick) {
    this.pick = pick;
  }

  int guess(int num) {
    if (pick < num) {
      return -1;
    } else if (pick > num) {
      return 1;
    }
    return 0;
  }

  public int guessNumber(int n) {
    int start = 1;
    int end = n;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int guess = guess(mid);
      if (guess == 0) {
        return mid;
      }
      if (guess == 1) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }
    return start;
  }

  @Test
  public void case1() {
    setPick(6);
    Assert.assertEquals(6, guessNumber(10));
  }

  @Test
  public void case2() {
    setPick(1);
    Assert.assertEquals(1, guessNumber(1));
  }

  @Test
  public void case3() {
    setPick(1);
    Assert.assertEquals(1, guessNumber(2));
  }

  @Test
  public void case4() {
    setPick(2);
    Assert.assertEquals(2, guessNumber(2));
  }
}
