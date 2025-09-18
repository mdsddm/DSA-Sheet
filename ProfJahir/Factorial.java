package ProfJahir;

public class Factorial {
    public static void main(String[] args) {
        int[] fact = getFactorial(5);
        for (int i = fact.length - 1; i >= 0; i--)
            System.out.print(fact[i]);
    }

    public static int[] getFactorial(int num) {
        if (num < 0) return new int[]{0};
        if (num == 0 || num == 1) return new int[]{1};
        int size = getDigit(num);
        int[] ans = new int[size];
        ans[0] = 1;
        int dig = 1;
        for (int i = 2; i <= num; i++) {
            dig = multiply(i, ans, dig);
        }
        return ans;
    }

    public static int getDigit(int num) {
        double digits = 0;
        for (int i = 2; i <= num; i++) {
            digits += Math.log10(i);
        }
        return (int) Math.floor(digits) + 1;
    }

    public static int multiply(int x, int[] result, int size) {
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10;     // Store last digit of product in array
            carry = prod / 10;         // Remaining carry
        }

        // Put carry in result and increase size
        while (carry > 0) {
            result[size] = carry % 10;
            carry /= 10;
            size++;
        }

        return size;
    }

}
