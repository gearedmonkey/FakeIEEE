package longatoj;

import java.awt.Color;

public class Node implements Comparable {
	private int number;
	private Color color;
	private boolean visited;

	public Node(int number) {
		this.number = number;
		this.color = null;
		this.visited = false;
	}

	public void setColor(Color newColor) {
		this.color = newColor;
	}

	public int getNumber() {
		return this.number;
	}

	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public boolean equals(Object arg0) {
		Node obj = (Node) arg0;
		return this.number == obj.getNumber();
	}

	@Override
	public int compareTo(Object arg0) {
		Node obj = (Node) arg0;
		Integer i1 = new Integer(this.number);
		Integer i2 = new Integer(obj.getNumber());
		return i1.compareTo(i2);
	}

	public Color getColor() {
		return this.color;
	}

	public void visit() {
		this.visited = true;
	}

	public boolean hasBeenVisisted() {
		return this.visited;
	}

	public void clear() {
		this.visited = false;
	}

}
