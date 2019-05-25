package datatype.tree.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree representation.
 */
public class Node<T> {

	public enum Color{
		
		WHITE,
		GREY,
		BLACK;
		
	}
	
	
	private T value;
	private boolean visited;
	private Color color;
	private List<Node<T>> vertices = new ArrayList<>();

	public Node(T value) {
		this.value = value;
		this.color = Node.Color.WHITE;
	}

	public void addVertex(Node<T> n) {
		vertices.add(n);
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + ", visited=" + visited + ", vertices="
				+ vertices + "]";
	}
	
	public void setLeft(Node<T> left) {
		this.vertices.add(left);
	}
	
	public void setRight(Node<T> right) {
		if (vertices.size()==0) {
			this.vertices.add(null);			
		}
		this.vertices.add(right);
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public T getValue() {
		return value;
	}
	
	public List<Node<T>> getVertices() {
		return vertices;
	}

	public Node<T> getLeft(){
		if (this.vertices.size() > 0) {
			return this.vertices.get(0);
		}
		return null;
	}
	
	public Node<T> getRight(){
		if (this.vertices.size() > 1) {
			return this.vertices.get(1);
		}
		return null;
	}
	
	public boolean isVisited() {
		return visited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
