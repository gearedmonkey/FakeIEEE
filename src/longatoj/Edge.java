package longatoj;

import java.util.ArrayList;
import java.util.List;

public class Edge {
	private int weight;
	private List<Node> endPoints;
	public Edge(Node n1, Node n2, int weight){
		endPoints = new ArrayList<Node>();
		this.weight = weight;
		endPoints.add(n1);
		endPoints.add(n2);
	}

	public int getWeight() {
		return weight;
	}
	public List<Node> getEndPoints(){
		return this.endPoints;
	}
	@Override
	public String toString(){
		return endPoints.get(0) + "<--->" + endPoints.get(1);
	}
	@Override
	public boolean equals(Object obj) {
		Edge otherEdge = (Edge) obj;
		List<Node> otherEdgeEndPoints = otherEdge.getEndPoints();
		return otherEdgeEndPoints.containsAll(endPoints);
	}

	public int getEdgeValue() {
		return weight;
	}
	
}
