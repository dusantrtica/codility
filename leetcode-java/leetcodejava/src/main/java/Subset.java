import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {
    public void printSubsets (List<List<Integer>> subSets) {
        for(List<Integer> subSet : subSets) {
            System.out.print("{");
            for(Integer e : subSet) {
                System.out.print(e + ", ");
            }
            System.out.print("}");
            System.out.print("   ");
        }
    }
    public List<List<Integer>> subSet(int[] set) {
        assert set.length <= 10;

        int n = set.length;

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int j = 1; j < Math.pow(2, n); j++) {
            int i = j;
            int index = 0;
            List<Integer> subSet = new ArrayList<>();
            while (i != 0) {
                if ((i & 1) == 1) {
                    subSet.add(set[index]);
                }
                index++;
                i = i >> 1;
            }
            result.add(subSet);
        }

        return result;
    }

    @Test
    public void case1() {
        printSubsets(subSet(new int []{}));
    }

    @Test
    public void singleElementSet() {
        printSubsets(subSet(new int []{1}));
    }

    @Test
    public void twoElementSet() {
        printSubsets(subSet(new int []{1,2}));
    }

    @Test
    public void threeElemementSet() {
        printSubsets(subSet(new int []{1,2,3}));
    }

}
