package datatype.tree.dfs;

import org.junit.Assert;
import org.junit.Test;

import datatype.tree.utils.TreeUtils;
import datatype.tree.utils.TreeUtils.Node;

public class NextElementBST {

	//---------------------------------------------------------------------------------------------
	//------------------------  DFS, NEXT ELEMENT IN-ORDER------------------------------------------
	//---------------------------------------------------------------------------------------------
	
	@Test
	public void testFindNexElementBSTInOrder(){

		Node root = TreeUtils.getBST();
		
		int [] array = new int[]{20,8, 4,12,10,14,22,27,25};
		int [] next =  new int[]{22,10,8,14,12,20,25,-1,27};
		
		for (int i = 0; i < array.length; i++) {
			Node nodeInBST = TreeUtils.getNodeInBST(root, array[i]);
			if(next[i] == -1){
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSInOder(nodeInBST)==null);
			}else{					
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSInOder(nodeInBST).getValue()==next[i]);
			}	
		}
	}
	
	/**
	 * 1) Si el nodo dado tiene hijo dcho, el siguiente nodo sera el hijo mas a la izqda a partir de su hijo dcho. Si a partir de su
	 *  	hijo dcho no hay nodos a la izqda, el siguiente nodo sera el hijo dcho
	 *
	 * 2) Si el nodo dado no tiene hijo dcho, el siguiente nodo sera el primer padre al que se acceda, mientras se recorre el arbol hacia 
	 *  	arriba, y que sea accedido desde un hijo izqdo  
	 * 
	 */
	
	public Node giveTheNextNodeForAGivenNodeTravesingTreeDFSInOder(Node node){
		
		if(node.getRight() != null){
			node = node.getRight();
			while(node.getLeft()!=null){
				node = node.getLeft();
			}
			return node;
		}else{
			while(node.getParent() != null && node.getParent().getLeft() != node){
				node = node.getParent();
			}
			return node.getParent();
		}
	}
	
	
	//---------------------------------------------------------------------------------------------
	//------------------------  DFS, NEXT ELEMENT PRE-ORDER------------------------------------------
	//---------------------------------------------------------------------------------------------
	
	@Test
	public void testFindNexElementBSTPreOrder(){

		Node root = TreeUtils.getBST();
		
		int [] array = new int[]{20,8, 4,12,10,14,22,27,25};
		int [] next =  new int[]{ 8,4,12,10,14,22,27,25,-1};
		
		for (int i = 0; i < array.length; i++) {
			Node nodeInBST = TreeUtils.getNodeInBST(root, array[i]);
			if(next[i] == -1){
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSPreOder(nodeInBST)==null);
			}else{					
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSPreOder(nodeInBST).getValue()==next[i]);
			}	
		}
	}
	
	/**
	 *
	 * 1) Si desde el nodo dado puedo bajar a la izqda porque tiene hijo izqdo ese sera el siguiente nodo que buscamos
	 * 
	 * 2) Si el nodo dado no tiene hijo izqdo pero tiene hijo dcho, ese hijo derecho sera el siguiente nodo que buscamos
	 * 
	 * 3) Si el nodo dado no tiene ni hijo izqdo, ni hijo dcho, el siguiente nodo sera el que recorriendo el arbol hacia
	 * 		ariba, cuando acceda a un padre siendo un hijo izqdo, si ese padre tiene hijo dcho, ese sera el nodo buscado
	 *    
	 */
	public Node giveTheNextNodeForAGivenNodeTravesingTreeDFSPreOder(Node node){
		
		if(node.getLeft() != null){
			return node.getLeft();
		}else{
			if(node.getRight() != null){
				return node.getRight();
			}
			while(node.getParent() != null && node.getParent().getLeft() != node){
				node = node.getParent();
			}
			return node.getParent().getRight();
		}
	}
	
	//---------------------------------------------------------------------------------------------		
	//------------------------  DFS, NEXT ELEMENT POST-ORDER------------------------------------------
	//---------------------------------------------------------------------------------------------
	
	@Test
	public void testFindNexElementBSTPostOrder(){

		Node root = TreeUtils.getBST();
		
		int [] array = new int[]{20, 8, 4,12,10,14,22,27,25};
		int [] next =  new int[]{-1,25,10, 8,14,12,20,22,27};
		
		for (int i = 0; i < array.length; i++) {
			Node nodeInBST = TreeUtils.getNodeInBST(root, array[i]);
			if(next[i] == -1){
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSPostOder(nodeInBST)==null);
			}else{					
				Assert.assertTrue(giveTheNextNodeForAGivenNodeTravesingTreeDFSPostOder(nodeInBST).getValue()==next[i]);
			}	
		}
	}
	
	/**
	 * 1) Si el nodo dado es un hijo dcho, el siguiente nodo en el recorrido es mi padre
	 * 2) Si soy un hijo izqdo el siguiente nodo sera a partir de mi hermano dcho, su hijo mas a la izqda
	 * 		y si no tiene hijos mi padre, pues el siguiente nodo sera mi padre
	 *  
	 */
	public Node giveTheNextNodeForAGivenNodeTravesingTreeDFSPostOder(Node node){
		
		if(node.getParent() != null){
			if(node.getParent().getRight() == node){
				return node.getParent();
			}else{
				node = node.getParent();
				while(node.getRight() != null){
					node = node.getRight();
					if(node.getLeft() == null){
						continue;
					}else{
						node = node.getLeft();
						while(node.getLeft() != null){
							node = node.getLeft();
						}
					}
				}
				return node;
			}

		}
		return null;
		
	}	

	
}
