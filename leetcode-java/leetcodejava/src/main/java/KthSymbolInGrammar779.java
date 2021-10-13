import org.junit.Assert;
import org.junit.Test;

public class KthSymbolInGrammar779 {
  public int kthGrammar(int n, int k) {
    if(k == 1 || n == 1) {
      return 0;
    }
    int len = (int)Math.pow(2, n-1);

    if(k > len/2) {
      k = k - len/2;
      return 1-kthGrammar(n-1, k);
    } else {
      return kthGrammar(n-1, k);
    }
  }

  @Test
  public void case1() {
    Assert.assertEquals(0, kthGrammar(1, 1));
  }

  @Test
  public void case2() {
    Assert.assertEquals(0, kthGrammar(2, 1));
  }

  @Test
  public void case3() {
    Assert.assertEquals(1, kthGrammar(2,2));
  }

  @Test
  public void case4() {
    Assert.assertEquals(0, kthGrammar(3, 1));
  }

  @Test
  public void case5() {
    Assert.assertEquals(1, kthGrammar(4, 5));
  }
}
