package edu.northeastern;

public class Question2 {

    /**
     * Find nth Smallest of an unsorted array.
     *
     * @param arr
     * @param n
     */
    public void findNthSmallest(int[] arr, int n) {
        if (arr == null || arr.length == 0 || n < 0 || n >= arr.length) {
            return;
        }
        findNthSmallest(arr, n, 0, arr.length - 1);
    }

    private void findNthSmallest(int[] arr, int n, int low, int high) {
        if (low < high) {
            int pos = partition(arr, low, high);
            if (pos == arr.length - n) {
                System.out.println(arr[pos]);
                return;
            }
            findNthSmallest(arr, n, low, pos - 1);
            findNthSmallest(arr, n, pos + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int wall = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] > pivot) {
                wall++;
                swap(arr, i, wall);
            }
        }
        wall++;
        swap(arr, high, wall);
        return wall;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
