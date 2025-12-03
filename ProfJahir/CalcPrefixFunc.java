/*
 * CalcPrefixFunc.java
 *
 * What this program does:
 * - It looks for a pattern P inside a text T in two ways.
 *
 * 1) naveStrMatch: the simple way. It checks every possible position where
 *    the pattern could start in the text. If P has length m and T has
 *    length n, this can be slow (about n * m comparisons in the worst case).
 *
 * 2) naveStrMatchKMP: a smarter idea using the prefix function (called pi).
 *    The pi array tells us how many characters we can safely skip after a
 *    mismatch because some prefix of the pattern matches a suffix we've just
 *    seen. This is the main idea behind the KMP algorithm. This file shows
 *    the idea clearly, but the search loop is written in a didactic style so
 *    it's easier to follow for learning.
 *
 * Inputs/Outputs:
 * - Inputs are hard-coded in main() (T and P). The program prints where the
 *   pattern matches and also prints the pi array for the pattern.
 *
 * Tips:
 * - Read getk() to see how the pi values are computed for each position.
 * - If you want a production-ready KMP, the pi array can be built in O(m)
 *   time using the usual linear method. This version focuses on clarity.
 */

package ProfJahir;

public class CalcPrefixFunc {

    static void naveStrMatch(String T, String P) {
        int n = T.length(), m = P.length();
        // Naive search: place the pattern at every possible shift s
        // and check character-by-character if it matches.
        for (int s = 0; s <= n - m; s++) {
            boolean matched = true; // we'll flip to false on first mismatch
            // Compare the whole pattern against the substring of T.
            for (int i = 0; i < m; i++) {
                if (T.charAt(s + i) != P.charAt(i)) {
                    // found a mismatch at pattern index i -> not a match here
                    matched = false;
                    break;
                }
            }
            if (matched)
                System.out.println("Match found with shift = " + s);
        }
    }

    static void naveStrMatchKMP(String T, String P) {
        int n = T.length(), m = P.length();
        int pi[] = new int[m];
        // Build the pi array for the pattern P.
        // pi[i] = length of the longest proper prefix of P[0..i]
        // that is also a suffix of P[0..i].
        // Example: if P = "ababac", then pi = [0,0,1,2,3,0]
        for (int i = 1; i < m; i++) {
            pi[i] = getk(P, i);
        }
        System.out.println("Value of Pi function");
        for (int i = 0; i < pi.length; i++) {
            System.out.print(pi[i] + " ");
        }
        System.out.println();
        // Search using pi to skip comparisons.
        // This loop is written to be easy to read for students. It uses
        // the pi array to decide where to continue after checking some
        // characters of the pattern.
        int q = 1; // helper: we'll use pi[q-1] on the first iteration
        for (int s = 0; s <= n - m;) {
            boolean matched = true;
            // Start comparing from pattern index k = pi[q-1]. That means
            // we assume the first k characters (0..k-1) are already matched
            int k = pi[q - 1];
            int i = k; // actual pointer into the pattern for comparisons
            System.out.println("s = " + s + " i = " + i);
            // Continue comparing P[i..m-1] with T[s+i..s+m-1]
            for (; i < m; i++) {
                if (T.charAt(s + i) != P.charAt(i)) {
                    matched = false; // mismatch at this position
                    break;
                }
            }
            if (matched)
                System.out.println("Match found with shift = " + s);
            System.out.println("Testing s = " + s + " i = " + i);
            // i is how many characters we matched. Use that to compute the
            // next shift. q will be set to i (number matched). If q==0 we
            // set it to 1 to keep indexing simple in this demo.
            q = i;
            if (q == 0)
                q = 1;

            // Move s forward by q - pi[q-1]. This value is how many new
            // positions we can skip because the prefix-suffix overlap
            // guarantees they would match again.
            s = s + q - pi[q - 1];
        }
    }

    static int getk(String p, int i) {
        // Compute pi[i] by trying all possible prefix lengths. This is a
        // simple and clear method (not the fastest). For each i we try the
        // largest possible k and check if the prefix of length k+1 matches
        // the suffix that ends at i.
        int k = i - 1;
        boolean found;
        do {
            found = true;
            int l = i; // pointer to move left from i while comparing
            // compare p[j] with p[l] moving j leftwards from k and l leftwards
            for (int j = k; j >= 0; j--) {
                if (p.charAt(j) != p.charAt(l)) {
                    found = false;
                    break;
                }
                l--;
            }
            if (found) {
                break; // matched all compared characters
            }
            k--; // try a smaller candidate prefix length
        } while (true);
        return k + 1;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        String T = "abcdababababacaa", P = "ababac";
        naveStrMatch(T, P);
        naveStrMatchKMP(T, P);
    }
}
