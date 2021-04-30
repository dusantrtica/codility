import java.util.Arrays;
import java.util.HashMap;

public class SortByFreq1636 {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int val = map.getOrDefault(i, 0);
            map.put(i, val+1);
        }

        Integer[] input = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (a, b) -> {
            int diffFreq = map.get(a) - map.get(b);
            return diffFreq != 0 ? diffFreq : b - a;
        });
        return Arrays.stream(input).mapToInt(e -> e).toArray();
    }
}
