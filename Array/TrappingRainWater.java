package Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMAx = new int[n];
        leftMax[0] = height[0];
        rightMAx[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Integer.max(leftMax[i - 1], height[i]);
            // rightMAx[n-i-1]=Integer.max(rightMAx[n-i],height[n-i-1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMAx[i] = Integer.max(rightMAx[i + 1], height[i]);
        }
        int waterLevel, containWater = 0;
        for (int i = 0; i < n; i++) {
            waterLevel = Integer.min(leftMax[i], rightMAx[i]);
            containWater += waterLevel - height[i];
        }
        return containWater;
    }
}
