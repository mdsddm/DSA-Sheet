package ProfJahir;

public class MergeSort {

    public static void main(String[] args) {
        long start = System.nanoTime(); // or System.currentTimeMillis()


        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(nums, 0, nums.length - 1);


        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");

    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] dummy = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                dummy[k] = nums[i];
                i++;
            } else {
                dummy[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            dummy[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end) {
            dummy[k] = nums[j];
            j++;
            k++;
        }
        for (k = 0; k <= end - start; k++)
            nums[start + k] = dummy[k];

    }

    public static void sort(int[] nums, int start, int end) {
        if (end > start) {
            int mid = start + (end - start) / 2;
            // sub problem
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            // combining
            merge(nums, start, mid, end);
        }
    }
}