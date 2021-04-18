package c1.week1;

public class QuickSort {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition_(int[] A, int l, int r) {
        int pivot = A[l];
        int i = l + 1;
        int j = r;
        while (i < j) {
            while (j >= l && j > i && A[j] > pivot) {
                j--;
            }
            while (i <= r && i < j && A[i] < pivot) {
                i++;
            }
            swap(A, i, j);
        }
        swap(A, l, i);
        return i;
    }

    private int partition(int [] A, int l, int r) {
        int p = A[l];
        int i = l+1;
        for (int j = l+1; j <= r; j++) {
            if (A[j] < p) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, l, i-1);
        return i-1;
    }

    public void quicksort(int[] A, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int pivotIndex = partition(A, low, high);
        quicksort(A, low, pivotIndex);
        quicksort(A, pivotIndex + 1, high);
    }
}
