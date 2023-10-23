import java.util.*;

public class DS {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(i);
            }
        }

        int findParent(int x) {
            if (x == parent.get(x)) {
                return x;
            }
            parent.set(x, findParent(parent.get(x)));
            return parent.get(x);
        }

        void unionFind(int a, int b) {
            int pa = findParent(a);
            int pb = findParent(b);
            if (pa == pb) {
                return;
            } else if (rank.get(a) > rank.get(b)) {
                parent.set(b, a);
            } else if (rank.get(a) < rank.get(b)) {
                parent.set(a, b);
            } else {
                parent.set(a, b);
                rank.set(a, rank.get(a) + 1);
            }
        }
    }

    public static void main(String args[]) {
        DisjointSet d = new DisjointSet(8);
        d.unionFind(1, 2);
        d.unionFind(2, 3);
        d.unionFind(4, 5);
        d.unionFind(6, 7);
        d.unionFind(5, 6);
        System.out.println(d.findParent(3) + " " + d.findParent(7));
        d.unionFind(3, 7);
        System.out.println(d.findParent(3) + " " + d.findParent(7));
    }
}
