import org.junit.Assert;
import org.junit.Test;

public class IsSubsequence392 {
    public boolean isSubsequence(String ss, String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        if (s.length > t.length) {
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < s.length) {
            while(j < t.length && t[j] != s[i]) {
                j++;
            }
            if(j == t.length) {
                break;
            }
            i++;
            j++;
        }

        return i == s.length;
    }

    @Test
    public void case1() {
        Assert.assertEquals(true, isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void case2() {
        Assert.assertEquals(false, isSubsequence("axc", "ahbgdc"));
    }

    @Test
    public void case3() {
        Assert.assertEquals(false, isSubsequence("aaaaaa",
                "bbaaaa"));
    }
}
