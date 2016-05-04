package longatoj;

import java.util.List;

public class Vroom {
	
	public static void main(String[] args){
		Graph myGraph = new Graph();
//		boolean isEntering = true;
//		Scanner scan = new Scanner(System.in);
//		do{
//			System.out.println("Enter edge pair");
//			String line = scan.nextLine();
//			if(line.equals("END")){
//				isEntering = false;
//			}else{
//				String[] tokens = line.split(" ");
//				try{
//					myGraph.addPath(new Node(Integer.valueOf(tokens[0])), new Node(Integer.valueOf(tokens[1])));
//				}catch(Exception e){
//					System.out.println("oops");
//				}
//			}
//		}while(isEntering);
//		myGraph.addPath(new Node(1), new Node(2), 0);
//		myGraph.addPath(new Node(1), new Node(6), 1);
//		myGraph.addPath(new Node(6), new Node(5), 2);
//		myGraph.addPath(new Node(6), new Node(7), 3);
//		myGraph.addPath(new Node(2), new Node(5), 4);
//		myGraph.addPath(new Node(7), new Node(4), 5);
//		myGraph.addPath(new Node(4), new Node(2), 6);
//		myGraph.addPath(new Node(4), new Node(3), 7);
//		myGraph.addPath(new Node(3), new Node(2), 8);
//		myGraph.addPath(new Node(5), new Node(7), 9);
//		myGraph.addPath(new Node(3), new Node(5), 10);
		myGraph.addPath(new Node(1), new Node(2), 1);
		myGraph.addPath(new Node(1), new Node(3), 7);
		myGraph.addPath(new Node(2), new Node(3), 3);
		myGraph.addPath(new Node(2), new Node(4), 20);
		myGraph.addPath(new Node(3), new Node(4), 2);
		System.out.println("printing adjaceny list...");
		System.out.println(myGraph);
		List<Path> n = myGraph.shortestPath(new Node(3), new Node(4), 3);
		System.out.println("FINAL RESULT: " + n);
		
	}
}
