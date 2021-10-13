package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestLetterGreaterThanTarget {

  char[] letters = new char[]{'c', 'f', 'j'};

  public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    int start = 0;
    int end = n-1;

    while(start <= end) {
      int mid = (start + end)/2;
      if(letters[mid] == target) {
        return letters[(mid+1)%n];
      } else if (letters[mid] < target) {
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return letters[start%n];
  }

  @Test
  public void case1() {
    Assert.assertEquals('c', nextGreatestLetter(letters, 'a'));
  }

  @Test
  public void case2() {
    Assert.assertEquals('f', nextGreatestLetter(letters, 'c'));
  }

  @Test
  public void case3() {
    Assert.assertEquals('f', nextGreatestLetter(letters, 'd'));
  }

  @Test
  public void case4() {
    Assert.assertEquals('j', nextGreatestLetter(letters, 'g'));
  }

  @Test
  public void case5() {
    Assert.assertEquals('c', nextGreatestLetter(letters, 'j'));
  }

  @Test
  public void case6() {
    Assert.assertEquals('c', nextGreatestLetter(letters, 'k'));
  }

}
