package ProfJahir;

// 21-08-2025 : define disjoint set class

public class DisjointSetClass {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);
        ds.merge(2, 4);
        ds.merge(2, 7);
        ds.merge(2, 10);
        ds.merge(3, 6);
        ds.merge(3, 8);
        ds.merge(3, 9);

        // Merge set {2,4,7,10} and {3,6,8,9}
        ds.merge(2, 3);

        ds.printParents(); // Print array after unions/merges
        System.out.println(ds.equal(4, 9)? "(4 & 9)-> Yes, it's equal.":"No, It's not equal."); // true if 4 and 9 are in the same set
    }
}

class DisjointSet {
    int[] parent;

    // Make set: Initialize with n elements, each as its own parent
    public DisjointSet(int n) {
        parent = new int[n + 1]; // Assuming 1-based indexing
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // Find: Returns the representative (root) of x
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // Merge/Union: Merge sets containing p and q
    public void merge(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            // Simple merge (no union by rank/size)
            if (rootQ > rootP) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
        }
    }

    // Equal: Check if p and q are in the same set
    public boolean equal(int p, int q) {
        return find(p) == find(q);
    }

    // Utility: Print parent array
    public void printParents() {
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
