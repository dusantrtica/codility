import org.junit.Assert;
import org.junit.Test;

public class AddBinary {

  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int s = 0;

    int i = a.length() - 1;
    int j = b.length() - 1;

    while(i >= 0 || j >= 0) {
      s += ((i >= 0) ? a.charAt(i) - '0' : 0);
      s += ((j >= 0) ? b.charAt(j) - '0' : 0);

      result.append((char)(s % 2 + '0'));
      s /= 2;
      i--;
      j--;
    }
    if(s == 1) {
      result.append((char)(s % 2 + '0'));
    }
    return result.reverse().toString();
  }

  @Test
  public void case1() {
    Assert.assertEquals("100", addBinary("11", "1"));
  }

  @Test
  public void case2() {
    Assert.assertEquals("10101", addBinary("1010", "1011"));
  }
}
