import java.util.List;

public class Tree {
    private Object root; // Use Object to allow any data type as the root
    private List<Tree> subtrees;

    public Tree(Object root, List<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public boolean is_empty() {
        return root == null;
    }

    public int len() {
        if (is_empty()) {
            return 0;
        } else {
            int size = 1;
            for (Tree subtree : subtrees) {
                size += subtree.len();
            }
            return size;
        }
    }

    public int occurrences(Object item) {
        if (is_empty()) {
            return 0;
        } else {
            int count = 0;
            if (root.equals(item)) {
                count++;
            }
            for (Tree subtree : subtrees) {
                count += subtree.occurrences(item);
            }
            return count;
        }
    }

    public String to_string(String[] args) {
        return str_indented(0);
    }

    public String str_indented(int depth) {
        if(is_empty()) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                builder.append("  "); // Indentation
            }
            builder.append(root.toString()).append("\n");
            for (Tree subtree : subtrees) {
                builder.append(subtree.str_indented(depth + 1));
            }
            return builder.toString();
        }
    }

    public double average() {
        if (is_empty()) {
            return 0.0;
        } else {
            double[] result = averageHelper();
            return result[0] / result[1];
        }
    }

    private double[] averageHelper() {
        double total = 0.0;
        int count = 0;

        if (!is_empty()) {
            total = Double.parseDouble(root.toString());
            count = 1;
            for (Tree subtree : subtrees) {
                double[] subtreeResult = subtree.averageHelper();
                total += subtreeResult[0];
                count += subtreeResult[1];
            }
        }

        return new double[]{total, count};
    }


    public boolean equals(Tree other) {
        if (root == null || other.root == null) {
            return true;
        } else if (root != other.root) {
            return false;
        } else {
            for(Tree subtree : other.subtrees) {
                return equals()
            }
        }
        return false;
    }

    public static void contains(String[] args) {

    }

    public static void leaves(String[] args) {

    }

    public static void delete(String[] args) {

    }

    public static void delete_root(String[] args) {
        //replaces ancestral node with left-most leaf
    }

    public static void extract(String[] args) {
        //removes and returns left-most leaf
    }

    public static void insert(String[] args) {
        /*
        Insert <item> into this tree using the following algorithm.

        1. If the tree is empty, <item> is the new root of the tree.
        2. If the tree has a root but no subtrees, create a
           new tree containing the item, and make this new tree a subtree
           of the original tree.
        3. Otherwise, pick a random number between 1 and 3 inclusive.
            - If the random number is 3, create a new tree containing
              the item, and make this new tree a subtree of the original.
            - If the random number is a 1 or 2, pick one of the existing
              subtrees at random, and *recursively insert* the new item
              into that subtree.
              */
}

}
