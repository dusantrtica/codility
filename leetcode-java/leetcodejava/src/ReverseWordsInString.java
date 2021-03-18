import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInString {

  public void reverse(char[] nums, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      char temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  private int removeDoubleSpacesAndTrim (char [] s) {
    return 0;
  }

  public String reverseWords(String s) {
    char [] chars = s.toCharArray();
    return new String(chars);
  }

  public static void main(String[] args) {

  }

  @Test
  public void sample1() {
    String result = reverseWords("the sky is blue");
    Assert.assertEquals(result, "blue is skye the");
  }

  @Test
  public void sample2() {
    String result = reverseWords("  hello world  ");
    Assert.assertEquals(result, "world hello");
  }

  @Test
  public void sample3() {
    String result = reverseWords("a good   example");
    Assert.assertEquals(result, "example good a");
  }

  @Test
  public void sample4() {
    String result = reverseWords("  Bob    Loves  Alice   ");
    Assert.assertEquals(result, "Alice Loves Bob");
  }
}
