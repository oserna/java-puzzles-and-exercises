package datatype.tree.lca;

public class LowestCommonAncestorBinaryTree {
    
    public static void main(String args[]) {
        /**
         * Create a sample Binary Tree. A Binary datatype.tree does not have to maintain
         * left <root < right relationship.
         */
    	NodeImpl root = new NodeImpl(1);
        root.left = new NodeImpl(2);
        root.right = new NodeImpl(4);
        root.left.left = new NodeImpl(6);
        root.left.right = new NodeImpl(5);
 
        root.right.left = new NodeImpl(9);
        root.right.right = new NodeImpl(11);
        root.right.right.left = new NodeImpl(7);
        root.right.right.right = new NodeImpl(3);
 
        System.out.println("Lowest Common Ancestor of NodeImpl 3 and 9 is: "
                + findLowestCommonAncestor(root, root.right.right.right, root.right.left).value);
         
        System.out.println("Lowest Common Ancestor of NodeImpl 3 and null is: "
                + findLowestCommonAncestor(root, root.right.right.right, null).value);
         
        System.out.println("Lowest Common Ancestor of NodeImpl 11 and null is: "
                + findLowestCommonAncestor(root, root.right.right, null).value);
 
    }
     
    /**
     * Recursive approach to find the Lowest Common Ancestor
     * @param root
     * @param a - first NodeImpl
     * @param b - second NodeImpl
     * @return NodeImpl that is lowest common ancestor of both a and b
     */
    public static NodeImpl findLowestCommonAncestor(NodeImpl root, NodeImpl a, NodeImpl b) {
 
        NodeImpl left = null;
        NodeImpl right = null;
 
        if (root == null) {
            return null;
        }
 
        /**
         * If NodeImpl a or NodeImpl b is also the root, then the root itself is lowest common ancestor
         */
        if (root == a || root == b) {
            return root;
        }
 
        left = findLowestCommonAncestor(root.left, a, b);
        right = findLowestCommonAncestor(root.right, a, b);
 
        /**
         * If NodeImpl a and NodeImpl b lie in the left, their Lowest Common Ancestor is in the left.
         * If NodeImpl a and NodeImpl b lie in the right,their Lowest Common Ancestor is in the right.
         *
         * Otherwise, root is the Lowest common ancestor.
         */
        if (left != null && right != null) {
            return root;
        }
 
        return (left != null) ? left : right;
    }
}
/**
 * Binary Tree representation.
 */
class NodeImpl {
	
    NodeImpl left;
    NodeImpl right;
    int value;
    boolean visited;
     
    public NodeImpl(int value) {
        left = null;
        right = null;
        this.value = value;
    }
}
