import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Permutations46 {

  private void swap(int [] nums, int i, int j ) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void permute(String full) {
    permute("", full);
  }

  private static void permute(String prefix, String remainig) {
    if(remainig.length() == 0) {
      System.out.println(prefix);
      return;
    }

    for(int i = 0; i < remainig.length(); i++) {
      permute(prefix + remainig.charAt(i), remainig.substring(0, i) + remainig.substring(i+1, remainig.length()));
    }
  }

  @Test
  public void case1() {
    permute("abcd");
  }
}
