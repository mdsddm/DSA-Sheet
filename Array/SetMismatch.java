package Array;
/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and
loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:
Input: nums = [1,1]
Output: [1,2]
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums={1,1};
        for(int a:findErrorNums(nums))
            System.out.print(a);

    }
    public static int[] findErrorNums(int[] nums) {
        int maxNum=Integer.MIN_VALUE;
        for(int num:nums)
            maxNum=Integer.max(maxNum,num);
        int a=-1,b=-1;
        int[] newArr=new int[maxNum+2];
        for (int num:nums)
            newArr[num]++;
        for(int i=1;i<=maxNum+1;i++){
            if(newArr[i]==2)
                a=i;
            if(newArr[i]==0)
                b=i;
            if (a!=-1 && b!=-1)
                return new int[]{a,b};
        }
        return new int[]{a,b};
    }
}
