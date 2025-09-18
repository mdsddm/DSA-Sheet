package ProfJahir;

import java.util.Arrays;

public class PermutationNonRecursive {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        startPermutation(a1);
    }

    // method that show execution time
    public static void startPermutation(int[] a) {
        long start = System.nanoTime(); // or System.currentTimeMillis()


        printAllPermutation(a);


        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;
        System.out.println("\nProgram executed in " + durationMs + " ms");

    }

    public static void printAllPermutation(int[] a) {
        Arrays.sort(a);
        do {
            System.out.println(Arrays.toString(a));
        } while (getNextPer(a));
    }

    public static boolean getNextPer(int[] a) {
        // largest i s.t. a[i] > a[i+1]
        int i = a.length - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }

        // checking for false condition
        if (i == -1) {
            return false;
        }

        // largest j s.t. a[j] > a[i]
        int j = a.length - 1;
        while (a[j] < a[i]) j--;

        // after finding i & j exchange
        swap(a, i, j);

        // after exchanging reverse rest array -> i+1 to n-1
        reverseArray(a, i + 1);

        // return true
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void reverseArray(int[] a, int st) {
        int end = a.length - 1;
        while (end > st) {
            swap(a, st, end);
            st++;
            end--;
        }
    }
}
