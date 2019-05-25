package datatype.tree.balance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oserna on 6/3/16.
 */
public class MakeAVLTreeBalance {

    public static void main(String[] args) {

        Node<Integer> nine = new Node<>(null, null, 9);
        Node<Integer> fourteen = new Node<>(null, null, 14);
        Node<Integer> nineteen = new Node<>(null, null, 19);
        Node<Integer> sixtySeven = new Node<>(null, null, 67);

        Node<Integer> twelve = new Node<>(nine, fourteen, 12);
        Node<Integer> twentyThree = new Node<>(nineteen, null, 23);
        Node<Integer> fiftyFour = new Node<>(null, sixtySeven, 54);
        Node<Integer> seventySix = new Node<>(null, null, 76);

        Node<Integer> seventeen = new Node<>(twelve, twentyThree, 17);
        Node<Integer> seventyTwo = new Node<>(fiftyFour, seventySix, 72);

        Node<Integer> root = new Node<>(seventeen, seventyTwo,  50);

        final Node<Integer> father = insertNode(root, new Node<Integer>(null, null, 18));

        if (!isBalanced(root)) {
			List<Node> unbalanceTrees = new ArrayList<>();
			getUnbalanceTrees(root, unbalanceTrees);
			System.out.println(unbalanceTrees);
		}
        
        System.out.println(father);
    }

    private static void getUnbalanceTrees(Node root, List<Node> unbalanceTrees) {
    	
    	if (root != null) {
			int leftHeight = height(root.getLeft());
			int rightHeight = height(root.getRight());
			
			if (Math.abs(leftHeight - rightHeight) > 1) {
				unbalanceTrees.add(root);
			}
			
			getUnbalanceTrees(root.getLeft(), unbalanceTrees);
			getUnbalanceTrees(root.getRight(), unbalanceTrees);
		}
    	
    }

    private static boolean isBalanced(Node node) {
    	
    	if (node == null) {
    		return true;
    	}

    	int leftHeight = height(node.getLeft());
    	int rightHeight = height(node.getRight());
    	
    	if (Math.abs(leftHeight - rightHeight) > 1) {
    		return false;
    	}
    	
    	boolean leftBalanced = isBalanced(node.getLeft());
    	boolean rightBalanced = isBalanced(node.getRight());
    	
    	return leftBalanced && rightBalanced;
    	
    }
    
    private static int height(Node node) {
    	
    	if (node == null) {
    		return 0;
    	} else {
    		int leftHeight = height(node.getLeft());
    		int rightHeight = height(node.getRight());
    		
    		return Math.max(leftHeight, rightHeight) + 1;
    	}
    }
    


    private static Node<Integer> insertNode(Node<Integer> root, Node<Integer> node){

        if (node.getValue() == root.getValue()) {
            throw new RuntimeException("Already present in the tree");
        }

        Node<Integer> next = node.getValue() > root.getValue() ? root.right : root.left;

        if (next == null) {
            if (node.getValue() > root.getValue()) {
                root.right = node;
            }
            root.left = node;

            return root;
        }else {
            return insertNode(next, node);
        }

    }
}
