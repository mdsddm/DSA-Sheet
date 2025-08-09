package ProfJahir;


public class QuickSort {
    public static void main(String[] args) {
        long start = System.nanoTime(); // or System.currentTimeMillis()


        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(nums, 0, nums.length - 1);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");

    }

    public static void sort(int[] nums, int start, int end) {
        if (end > start) {
            // finding pivot
            int pivotPoint = partition(nums, start, end);
            sort(nums, start, pivotPoint - 1);
            sort(nums, pivotPoint + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int pivotElement = nums[start], j = start;
        for (int i = start + 1; i <= end; i++) {
            if (pivotElement > nums[i]) {
                j++;
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int pivotPoint = j;
        if (start != pivotPoint) {
            int temp = nums[start];
            nums[start] = nums[pivotPoint];
            nums[pivotPoint] = temp;
        }

        return pivotPoint;
    }
}
