package longatoj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
	private Map<Node, List<Node>> adjacencyList;
	private List<Edge> edgeList;
	private List<Path> paths;
	private Path potentialPath;

	public Graph() {
		adjacencyList = new TreeMap<Node, List<Node>>();
		edgeList = new ArrayList<Edge>();
		potentialPath = new Path();
		paths = new ArrayList<Path>();
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
	
	public Path shortestPath(Node start, Node end, int k) {
		Path leastCostPath = null;
		List<Path> allPathsToEnd = this.shortestPathHelper(start, end, k);
		int min = Integer.MAX_VALUE;
		for(Path p : allPathsToEnd){
			if(p.getPathTotal() < min){
				leastCostPath = p;
				min = p.getPathTotal();
			}
			else if(p.getPathTotal() == min){
				if(p.getTrail().size() < leastCostPath.getTrail().size())
					leastCostPath = p;
			}
			
		}
		return leastCostPath;

	}
	private List<Path> shortestPathHelper(Node start, Node end, int k){
		List<Node> children = adjacencyList.get(start);
		potentialPath.add(start);
		if (!start.equals(end)) {
			for (Node child : children) {
				if (!child.hasBeenVisisted() && k > 0) {
					this.visitAll(start);
					Edge e = findEdge(start, child);
					potentialPath.addToTotal(e.getEdgeValue());
					shortestPathHelper(child, end, k - 1);
					potentialPath.reduceTotal(e.getEdgeValue());
					this.clearAll(child);
				}
			}
		}
		if (potentialPath.size() != 0 && potentialPath.getLast().equals(end))
			this.paths.add(Path.copyOf(potentialPath));
		potentialPath.remove(start);
		return paths;
	}
	private void clearAll(Node child) {
		for (List<Node> list : this.adjacencyList.values()) {
			for (Node n : list) {
				if (n.equals(child))
					n.clear();
			}
		}

	}

	// Terrible method
	private void visitAll(Node start) {
		for (List<Node> list : this.adjacencyList.values()) {
			for (Node n : list) {
				if (n.equals(start))
					n.visit();
			}
		}
	}

	// Another terrible method
	private Edge findEdge(Node n1, Node n2) {
		Edge e = new Edge(n1, n2, 0);
		for (Edge edges : this.edgeList) {
			if (edges.equals(e))
				return edges;
		}
		return null;
	}
}
