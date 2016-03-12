package datatype.tree.balance;

/**
 * Created by oserna on 6/3/16.
 */
public class Node<T> {

    T value;

    int height;

    Node<T> left ;
    Node<T> right;

    public Node(Node<T> left, Node<T> right, T value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

	@Override
	public String toString() {
		String leftValue = left != null ? left.getValue() + "" : "";
		String rightValue = right != null ? right.getValue() + "" : "";
		return "[ Value: " + getValue() + ", I: " + leftValue + ", R: " + rightValue + "]";
	}
	
}


