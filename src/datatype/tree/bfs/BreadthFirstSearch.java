package datatype.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import datatype.tree.Node;

public class BreadthFirstSearch<T> {

	public Node<T> bfsTraverse(Node<T> rootNode, Criteria<Node<T>> criteria) {

		// creates the queue
		Queue<Node<T>> queue = new LinkedList<Node<T>>();

		// put the root Node<T> on the queue
		queue.add(rootNode);

		while (!queue.isEmpty()) {

			// dequeue the current Node<T>
			Node<T> current = queue.poll();

			// set Node<T> as visited
			current.setVisited(true);

			// test if the polled Node<T> is the searched one
			if (criteria.match(current)) {
				return current;
			}

			//visit the neightbours of the current node
			//adding them to the queue if they have not already visited
			for (Node<T> vertice : current.getVertices()) {
				if (vertice.isVisited())
					continue;
				queue.add(vertice);
			}

		}

		// There is no Node<T> who match with the current criteria
		return null;
	}
}
