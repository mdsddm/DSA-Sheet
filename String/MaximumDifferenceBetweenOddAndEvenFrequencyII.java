package String;
/*  3445. Maximum Difference Between Even and Odd Frequency II
You are given a string s and an integer k. Your task is to find the maximum difference between the frequency of
two characters, freq[a] - freq[b], in a substring subs of s, such that:
subs has a size of at least k.
Character a has an odd frequency in subs.
Character b has an even frequency in subs.
Return the maximum difference.
Note that subs can contain more than 2 distinct characters.

Example 1:
Input: s = "12233", k = 4
Output: -1
Explanation:
For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1.

Example 2:
Input: s = "1122211", k = 3
Output: 1
Explanation:
For the substring "11222", the frequency of '2' is 3 and the frequency of '1' is 2. The difference is 3 - 2 = 1.

Example 3:
Input: s = "110", k = 3
Output: -1

Constraints:
3 <= s.length <= 3 * 104
s consists only of digits '0' to '4'.
The input is generated that at least one substring has a character with an even frequency and a character with an odd frequency.
1 <= k <= s.length

 */
public class MaximumDifferenceBetweenOddAndEvenFrequencyII {
    public static void main(String[] args) {
        System.out.println(maxDifference("02024404",6));
    }
    public static int maxDifference(String s, int k) {
        int n = s.length();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) vals[i] = s.charAt(i) - '0';
        int res = Integer.MIN_VALUE;
        int[] d = new int[n+1], pa = new int[n+1], cb = new int[n+1];
        int[][] cb_list = new int[4][n+1], dm = new int[4][n+1];
        int[] ptr = new int[4], sz = new int[4];
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) continue;
                d[0] = pa[0] = cb[0] = 0;
                for (int i = 1; i <= n; i++) {
                    int v = vals[i-1], da = (v==a)?1:0, db = (v==b)?1:0;
                    d[i] = d[i-1] + da - db;
                    pa[i] = pa[i-1] ^ da;
                    cb[i] = cb[i-1] + db;
                }
                for (int t = 0; t < 4; t++) { ptr[t] = 0; sz[t] = 0; }
                for (int j = k; j <= n; j++) {
                    int i = j - k;
                    int idx = (pa[i] << 1) | (cb[i] & 1);
                    int di = d[i], szi = sz[idx];
                    dm[idx][szi] = (szi==0?di:Math.min(dm[idx][szi-1], di));
                    cb_list[idx][szi] = cb[i];
                    sz[idx] = szi + 1;
                    int td = ((pa[j] ^ 1) << 1) | (cb[j] & 1), T = cb[j] - 2, p = ptr[td], szt = sz[td];
                    while (p < szt && cb_list[td][p] <= T) p++;
                    ptr[td] = p;
                    if (p > 0) {
                        int diff = d[j] - dm[td][p-1];
                        if (diff > res) res = diff;
                    }
                }
            }
        }
        return res;
    }
}
