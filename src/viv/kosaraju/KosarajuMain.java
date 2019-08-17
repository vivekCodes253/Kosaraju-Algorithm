package viv.kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import viv.graph.Edge;
import viv.graph.Graph;
import viv.graph.Vertex;

public class KosarajuMain {

	private static Graph graph; 
	private static List<Vertex> vertexList = new ArrayList<>();
	private static List<Edge> edgeList =  new ArrayList<>();
	private static Stack<Integer> stack = new Stack<>();
	private static boolean[][] adjacency =
		{{false,true,false,false,false,false,false,false,false,false,false},
		{false,false,true,true,false,false,false,false,false,false,false},
		{true,false,false,false,false,false,false,false,false,false,false},
		{false,false,false,false,true,false,false,false,false,false,false},
		{false,false,false,false,false,true,false,false,false,false,false},
		{false,false,false,true,false,false,false,false,false,false,false},
		{false,false,false,false,false,true,false,true,false,false,false},
		{false,false,false,false,false,false,false,false,true,false,false},
		{false,false,false,false,false,false,false,false,false,true,false},
		{false,false,false,false,false,false,true,false,false,false,true},
		{false,false,false,false,false,false,false,false,false,false,false}};
	
	public static int vertexCount = 11;
	
	public static void main(String[] args) {
		
		graph = new Graph(adjacency,11);
		vertexList = graph.getVertexList();
		edgeList = graph.getEdgeList();
		Kosaraju();
		//System.out.println(graph.depthFirstSearch());
		
	}
	
	
	public static void Kosaraju() {
	
		//forward traverse
		System.out.println(depthFirstSearch(1,true));//update stack as one finishes
		//transpose
		transposeGraph();
		//display
		//System.out.println(graph.getGraphAsCharString());
		//reverse traverse
		System.out.println("Doing reverse");
		DFSinit();
		while(unvisitedNodesExist()) {
			
			if(!vertexList.get(stack.peek()).isVisited())
			{
				System.out.println("Stack top is "+stack.peek());
				System.out.println(depthFirstSearch(stack.pop(),false));
			}
			else
				stack.pop();
		}
		
	}
	
	public static void transposeGraph() {
		
		boolean[][] transposedAdjacency = new boolean[vertexCount][vertexCount];
		int i,j;
		for(i=0;i<vertexCount;i++)
			for(j=0;j<vertexCount;j++)
				transposedAdjacency[j][i] = adjacency[i][j];
		Graph transposedGraph = new Graph(transposedAdjacency,11);
		vertexList = transposedGraph.getVertexList();
		edgeList = transposedGraph.getEdgeList();
		graph = transposedGraph;
		
	}
	
	
	
	private static String displayStack() {
		StringBuilder sb = new StringBuilder();
		for(Integer i : stack) {
			sb.append(i+" ");
		}
		
		return sb.toString();
	}
	
	private static boolean allChildrenVisited(Vertex vertex) {
		
		for(Vertex v : vertex.getAdjacentList()) {
			if(v.isVisited()==false)
				return false;
		}
		
		return true;
	}
	
	
	private static void DFSinit(){
		for(Vertex v : vertexList){
			v.setVisited(false);
		}
	}
	
	
	
	public static String depthFirstSearch(){
		
		return depthFirstSearch(0,false);
	}
	
	public static boolean unvisitedNodesExist() {
		
		for(Vertex vertex : vertexList) {
			if(!vertex.isVisited())
				return true;
		}
		
		return false;
	}
	
	public static int getNextUnvisitedNode() {
		for(Vertex vertex : vertexList) {
			System.out.println("Tracking "+(char)('a'+vertex.getVertexName()));
			if(!vertex.isVisited()) {
				System.out.println("Exitting at "+(char)('a'+vertex.getVertexName()));
				return vertex.getVertexName();
			}
		}
		
		return 0;
	}
	
	public static String depthFirstSearch(int startNode, boolean checkAllElements) {
		if(checkAllElements) DFSinit();				//Initialise in Kosaraju fn if doing reverse.
		StringBuilder sb = new StringBuilder();
		sb.append(DFS(startNode, checkAllElements)+" ");
		if(checkAllElements) {
			while(unvisitedNodesExist()) {
				sb.append(DFS(getNextUnvisitedNode(), checkAllElements)+" ");
			}
		}
		return sb.toString();
	}
	
	
	private static String DFS(int startNode, boolean checkAllElements)
	{
		String depthFirst = "";
		StringBuilder sb = new StringBuilder();
		Vertex startVertex = vertexList.get(startNode);
		startVertex.setVisited(true);
		sb.append(startNode+" ");
		
		
		
		for(Vertex child : startVertex.getAdjacentList()) {
			
			
			
			if(child.isVisited()==false) {
					sb.append(DFS(child.getVertexName(), checkAllElements)+" ");
			}
			if(checkAllElements) {	//only for forward case, no pushing for reverse case
				if(child.hasNoChildren()) {
					System.out.println("Pushing " + (char)('a'+child.getVertexName()));
					stack.push(child.getVertexName());
				}
				if(allChildrenVisited(startVertex)) {
					System.out.println("Pushing " + (char)('a'+startVertex.getVertexName()));
					stack.push(startVertex.getVertexName());
					break;
				}
				
			}
				
		}
		
	
		depthFirst = sb.toString();
		return depthFirst;
		
	}

}
