package c1.week1;

import org.junit.Assert;
import org.junit.Test;

public class KaratsubaMulSpec {
  KaratsubaMul karatsubaMul = new KaratsubaMul();

  @Test
  public void singleDigitOperands () {
    Assert.assertEquals(6, karatsubaMul.multiply(3,2));
  }

  @Test
  public void twoDigitsOperands () {
    Assert.assertEquals(120, karatsubaMul.multiply(12,10));
  }

  @Test
  public void sample () {
    Assert.assertEquals(7006652, karatsubaMul.multiply(1234,5678));
  }

  @Test
  public void differentLengthOperands () {
    Assert.assertEquals(5535, karatsubaMul.multiply(123,45));
  }
}
