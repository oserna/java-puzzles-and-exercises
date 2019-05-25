package datatype.tree.balance;

/**
 * Created by oserna on 6/3/16.
 */
public class BalanceTreeVersionTwo {

    public static void main(String[] args) {

        Node<String> k = new Node<>(null, null, "K");
        Node<String> l = new Node<>(null, null, "L");

        Node<String> i = new Node<>(k, null, "I");
        Node<String> j = new Node<>(l, null, "J");
        Node<String> h = new Node<>(null, null, "H");

        Node<String> d = new Node<>(h, i, "D");
        Node<String> e = new Node<>(null, j, "E");
        Node<String> f = new Node<>(null, null, "F");
        Node<String> g = new Node<>(null, null, "G");

        Node<String> b = new Node<>(d, e, "B");
        Node<String> c = new Node<>(f, g, "C");

        Node<String> a = new Node<>(b, c,  "A");

        final boolean balanced = isBalanced(a);
        System.out.println(balanced);

    }


    private static boolean isBalanced(Node<String> root) {

        if (root == null) {
            return true;
        }

        final int leftDepth = depth(root.getLeft());
        final int rightDepth = depth(root.getRight());

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        final boolean leftBalanced = isBalanced(root.getLeft());
        final boolean rightBalanced = isBalanced(root.getRight());

        return leftBalanced && rightBalanced;
    }

    private static int depth (Node<String> node) {
        if (node == null) {
            return 0;
        }
        final int leftDepth = depth(node.getLeft());
        final int rightDepth = depth(node.getRight());

        if (leftDepth == rightDepth) {
            return leftDepth + 1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
