package c1.week1;

public class KthSmallest {
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private int partition(int[] A, int l, int r) {
        int p = A[l];
        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (A[j] < p) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, l, i-1);
        return i-1;
    }

    public int kSmallest(int[] A, int low, int high, int k) {
        if(high == low) {
            return A[high];
        }

        int pivotIdx = partition(A, low, high);

        if(pivotIdx - low == k) {
            return A[pivotIdx-1];
        }

        if(pivotIdx - low > k) {
            return kSmallest(A, low, pivotIdx-1, k);
        }
        return kSmallest(A, pivotIdx+1, high, k-pivotIdx + low -  1);
    }
}
