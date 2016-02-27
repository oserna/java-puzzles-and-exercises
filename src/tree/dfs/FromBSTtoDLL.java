package tree.dfs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tree.utils.TreeUtils;
import tree.utils.TreeUtils.Node;


/**
 * La solucion es la siguiente
 * 
 * Creamos un objeto lista lincada que al meterle el elemento siguiente
 * haga el doble enlace y mantega el ultimo añadido
 * 
 * Durante el recorrido de la manera que se requiera se añade el elemento
 * a la lista en el sitio correpondiente
 * 
 * @author oserna
 *
 */
public class FromBSTtoDLL {

	@Test
	public void test() {
		
		Node bst = TreeUtils.getBST();
		
		DLL dll = new DLL();
		traverse(bst, dll);
		System.out.println(dll);
	}
	
	
	private void traverse(Node root, DLL list){
		
		if(root == null)
		 	return;
		
		//if we want to create a DLL with the PRE ORDER list
		list.setNext(new DLLElement(root));

		traverse(root.getLeft(), list);
		
		// if we want to create a DLL with the IN ORDER list
		//list.setNext(new DLLElement(root));
		
		traverse(root.getRight(), list);
		
		// if we want to create a DLL with the POST ORDER list
		//list.setNext(new DLLElement(root));
	}
	
	static class DLL{

		private DLLElement current;
		
		void setNext(DLLElement element){
			if(current != null)
				current.setNext(element);
			element.setPrevious(current);
			current = element;
		}

	}
	
	static class DLLElement{
		
		private Node node;
		private DLLElement previous;
		private DLLElement next;
		
		public DLLElement(Node node) {
			this.node = node;
		}
		public void setElement(Node element) {
			this.node = element;
		}
		public Node getElement() {
			return node;
		}
		public void setPrevious(DLLElement previous) {
			this.previous = previous;
		}
		public DLLElement getPrevious() {
			return previous;
		}
		public void setNext(DLLElement next) {
			this.next = next;
		}
		public DLLElement getNext() {
			return next;
		}
		@Override
		public String toString() {
			return node.toString();
		}
	}

}
