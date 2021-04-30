import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class FreqSort451 {
    public String frequencySort(String ss) {
        char [] charArray = ss.toCharArray();
        int n = charArray.length;
        Character [] s = new Character[n];
        for(int i = 0; i < n; i++) {
            s[i] = charArray[i];
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : s) {
            int val = map.getOrDefault(c, 0);
            map.put(c, val+1);
        }

        Arrays.sort(s, (a, b) -> {
            int diffFreq = map.get(b) - map.get(a);
            return diffFreq != 0 ? diffFreq : Character.compare(a, b);
        });

        for(int i = 0; i < n; i++) {
            charArray[i] = s[i];
        }
        return new String(charArray);
    }

    @Test
    public void case1 () {
        Assert.assertEquals("eert", frequencySort("tree"));
    }

    @Test
    public void case2() {
        Assert.assertEquals("aaaccc", frequencySort("cccaaa"));
    }

    @Test
    public void case3 () {
        Assert.assertEquals("bbAa", frequencySort("Aabb"));
    }
}
