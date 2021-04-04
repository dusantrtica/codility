import org.junit.Assert;
import org.junit.Test;

public class DefangingIPAddress1108 {
    public String defangIPaddr(String address) {
        char[] s = address.toCharArray();
        int dotCount = 0;
        for (char elem : s) {
            if (elem == '.') {
                dotCount++;
            }
        }
        char[] t = new char[dotCount * 2 + address.length()];
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '.') {
                t[j++] = '[';
                t[j++] = '.';
                t[j++] = ']';
            } else {
                t[j++] = s[i];
            }
        }

        return new String(t);
    }

    @Test
    public void case1() {
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
    }

    @Test
    public void case2() {
        Assert.assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }
}

