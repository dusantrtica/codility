package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersion {

  private int badVersion;

  private void setBadVersion(int badVersion) {
    this.badVersion = badVersion;
  }

  public boolean isBadVersion(int version) {
    return version >= this.badVersion;
  }

  public int firstBadVersion(int n) {
    int start = 1;
    int end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  @Test
  public void case1() {
    setBadVersion(4);
    Assert.assertEquals(4, firstBadVersion(5));
  }

  @Test
  public void case2() {
    setBadVersion(3);
    Assert.assertEquals(3, firstBadVersion(10));
  }

  @Test
  public void case3() {
    setBadVersion(1);
    Assert.assertEquals(1, firstBadVersion(1));
  }

  @Test
  public void case4() {
    setBadVersion(2);
    Assert.assertEquals(2, firstBadVersion(2));
  }

  @Test
  public void case5() {
    setBadVersion(1702766719);
    Assert.assertEquals(1702766719, firstBadVersion(2126753390));
  }
}
