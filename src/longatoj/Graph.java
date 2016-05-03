package longatoj;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
	private Map<Node, List<Node>> adjacencyList;
	private List<Edge> edgeList;

	public Graph() {
		adjacencyList = new TreeMap<Node, List<Node>>();
		edgeList = new ArrayList<Edge>();
	}

	public void addPath(Node n1, Node n2, int value) {
		List<Node> start = (List<Node>) adjacencyList.get(n1);
		List<Node> end = (List<Node>) adjacencyList.get(n2);
		if (start == null) {
			this.addNewNode(n1);
		}
		if (end == null) {
			this.addNewNode(n2);
		}

		start = adjacencyList.get(n1);
		end = adjacencyList.get(n2);
		start.add(n2);
		end.add(n1);
		Edge e1 = new Edge(n1, n2, value);
		if (!edgeList.contains(e1))
			edgeList.add(e1);
	}

	private void addNewNode(Node newNode) {
		List temp = new ArrayList<Node>();
		adjacencyList.put(newNode, temp);
	}

	public void printEdgeList() {
		String s = "";
		for (Edge e : edgeList) {
			s += e.toString() + " Value: " + e.getEdgeValue() + "\n";
		}
		System.out.println(s);
	}

	public String toString() {
		String s = "";
		for (Node key : adjacencyList.keySet()) {
			s += key + "| ";
			for (Node neighbor : adjacencyList.get(key)) {
				s += neighbor + ", ";
			}
			s += "\n";
		}
		return s;
	}

	public Node shortestPath(Node start, Node end, int k) {
		start.visit();
		List<Node> children = adjacencyList.get(start);
		System.out.println("Start is: " + start + " " + children);
		for (Node child : children) {
			Edge e = findEdge(start, child);
			if (!child.hasBeenVisisted()) {
				child.visit();
				shortestPath(child, end, k - 1);
			}

		}

		return null;

	}

	private Object markKeyVisited(Node key, Node start) {
		return null;
	}

	private Edge findEdge(Node n1, Node n2) {
		Edge e = new Edge(n1, n2, 0);
		for (Edge edges : this.edgeList) {
			if (edges.equals(e))
				return edges;
		}
		return null;
	}
}
