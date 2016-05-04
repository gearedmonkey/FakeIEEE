package longatoj;

import java.util.LinkedList;
import java.util.List;

public class Path implements Cloneable {
	private int pathTotal;
	private LinkedList<Node> trail;
	
	public Path(){
		trail = new LinkedList<Node>();
	}
	
	public void add(Node n){
		trail.add(n);
	}
	public void addToTotal(int a){
		this.pathTotal += a;
	}

	public int getPathTotal() {
		return pathTotal;
	}

	public List<Node> getTrail() {
		return trail;
	}

	public static Path copyOf(Path p){
		Path newPath = new Path();
		for(Node n : p.getTrail()){
			newPath.add(n);
		}
		newPath.addToTotal(p.getPathTotal());
		return newPath;
	}

	public int size() {
		return this.trail.size();
	}

	public Object getLast() {
		return this.trail.getLast();
	}
	public String toString(){
		return trail.toString();
	}

	public void remove(Node start) {
		this.trail.remove(start);
		
	}

	public void reduceTotal(int edgeValue) {
		this.pathTotal -= edgeValue;
		
	}
	

	
}
