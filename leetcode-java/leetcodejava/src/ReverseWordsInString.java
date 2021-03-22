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

    public int removeDoubleSpacesAndTrim(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (s[start] == ' ')
            start++;
        while (s[end] == ' ')
            end--;

        boolean inSpaces = false;
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (s[i] == ' ') {
                if (inSpaces == false) {
                    s[j++] = s[i];
                    inSpaces = true;
                }
            } else {
                inSpaces = false;
                s[j++] = s[i];
            }
        }
        return j;
    }

    @Test
    public void removeDoubleSpacesAndTrimCase1() {
        String s = "the sky is blue";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        char[] chars = s.toCharArray();
        int len = reverseWordsInString.removeDoubleSpacesAndTrim(chars);
        String expected = "the sky is blue";
        String t = new String(chars).substring(0, len);
        Assert.assertEquals(expected, t);
    }

    @Test
    public void removeDoubleSpacesAndTrimCase2() {
        String s = "   hello  world   ";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        char[] chars = s.toCharArray();
        int len = reverseWordsInString.removeDoubleSpacesAndTrim(chars);
        String expected = "hello world";
        String t = new String(chars).substring(0, len);
        Assert.assertEquals(expected, t);
    }

    @Test
    public void removeDoubleSpacesAndTrimCase3() {
        String s = "abc";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        char[] chars = s.toCharArray();
        int len = reverseWordsInString.removeDoubleSpacesAndTrim(chars);
        String expected = "abc";
        String t = new String(chars).substring(0, len);
        Assert.assertEquals(expected, t);
    }


    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = this.removeDoubleSpacesAndTrim(chars);
        reverse(chars, 0, len - 1);
        int i = 0, j = 0;
        while (j < len) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }
        }
        reverse(chars, i, j-1);
        return new String(chars).substring(0, len);
    }

    @Test
    public void sample1() {
        String result = reverseWords("the sky is blue");
        Assert.assertEquals(result, "blue is sky the");
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
