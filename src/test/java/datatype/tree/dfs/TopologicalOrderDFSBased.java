package datatype.tree.dfs;

import java.util.List;

import org.junit.Test;

import datatype.tree.utils.Node;

public class TopologicalOrderDFSBased {

	@Test
	public void test2() {
		
		Node<String> dag = createDAG_2();
		traverseDAGDFSRecursively(dag);
	}
	
	
	
	private void traverseDAGDFSRecursively(Node<String> node){
		
		if(node == null)
			return;	

		
		List<Node<String>> vertices = node.getVertices();
		for (Node<String> vertex : vertices) {
			if(!vertex.isVisited()){				
				traverseDAGDFSRecursively(vertex);		
			}
		}
		
		node.setVisited(true);
		System.out.print(" "+node.getValue());
		
	}

	private Node<String> createDAG_2(){

		Node<String> p1 = new Node<String>("P1");
		Node<String> p2 = new Node<String>("P2");		
		Node<String> p3 = new Node<String>("P3");
		
		p1.addVertex(p3);
		p1.addVertex(p2);
		
		p3.addVertex(p2);
		
		return p1;
		
	}
	
	
	private Node<String> createDAG(){

		Node<String> a = new Node<String>("A");
		Node<String> b = new Node<String>("B");		
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		Node<String> e = new Node<String>("E");
		Node<String> f = new Node<String>("F");
		Node<String> g = new Node<String>("G");
		Node<String> h = new Node<String>("H");
		Node<String> i = new Node<String>("I");
		
		a.addVertex(b);
		a.addVertex(d);
		
		b.addVertex(c);
		
		c.addVertex(d);
		c.addVertex(e);
		
		d.addVertex(g);
		d.addVertex(e);
		
		f.addVertex(e);
		
		g.addVertex(i);
		g.addVertex(f);
		
		i.addVertex(f);
		
		h.addVertex(g);
		h.addVertex(d);

		return c;
	}

}
