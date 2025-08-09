package ProfJahir;

public class HeapSort {
    public static void main(String[] args) {
        long start = System.nanoTime(); // or System.currentTimeMillis()


        int[] arr = {12, 11, 13, 5, 6, 7};
        sort(arr);


        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");
    }


    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heap(arr, i, 0);
        }
    }


    public static void heap(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;

        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int num = arr[i];
            arr[i] = arr[largest];
            arr[largest] = num;
            heap(arr, n, largest);
        }
    }

}