package Array;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/
public class XPowerN {
    public static void main(String[] args) {
        System.out.println(myPow(3.00,2147483646));

    }
    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x==1)   return 1.0;
        if(x==(-1.0))
            return (n&1)==0 ?1.0:-1.0;
        long N = n; // Use long to avoid overflow for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }
}
