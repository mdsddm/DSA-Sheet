package Array;
/*  2566. Maximum Difference by Remapping a Digit
You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
Notes:
    When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
    Bob can remap a digit to itself, in which case num does not change.
    Bob can remap different digits for obtaining minimum and maximum values respectively.
    The resulting number after remapping can contain leading zeroes.

Example 1:
Input: num = 11891
Output: 99009
Explanation:
To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
The difference between these two numbers is 99009.

Example 2:
Input: num = 90
Output: 99
Explanation:
The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can be returned by the function is 0 (if 9 is replaced by 0).
Thus, we return 99.
 */
public class MaximumDifferenceByRemappingDigit {
    public static void main(String[] args) {
        System.out.println(minMaxDifference(99999));
    }
    // here we use string, this will handle 0 case:
    public static int minMaxDifference(int num){
        String str = String.valueOf(num);
        int i= 0, j=0;
        while (i<str.length() && str.charAt(i)=='9' )
            i++;
        i = (i==str.length() )? i-1 : i;
        int max = Integer.parseInt(str.replace(str.charAt(i),'9'));
        while (i<str.length() && str.charAt(j)=='0' )
            j++;
        j = (j==str.length() )? j-1 : j;
        int min = Integer.parseInt(str.replace(str.charAt(j),'0'));
        return max-min;
    }
    // this method not handle 0 in the last so changing approach
    public static int minMaxDifferenceI(int num) {
        int reverse = reverse(num);
        System.out.println("reverse : "+reverse);
        int first = reverse % 10;
        System.out.println("first : "+first);
        int max = 0;
        int min = 0;
        while (reverse>0){
            if(reverse%10==first){
                max = 10 * max + 9;
                min = 10 * min;
            } else {
                max = 10 * max + reverse % 10;
                min = 10 * min + reverse % 10;
            }
            reverse/=10;
        }
        System.out.println("max :"+max+"    min :"+min);
        return max-min;

    }
    public static int reverse(int num){
        int rev = 0;
        while (num>0){
            rev = 10 * rev + num % 10;
            num/=10;}
        return rev;
    }
}
