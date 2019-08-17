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
	public static void main(String[] args) {
		
		//Try dfs first
		
		//1) Create graph 
		
		boolean[][] adjacency =
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
			{false,false,false,false,false,false,false,false,false,false,false}
			
			};
		
	
		graph = new Graph(adjacency,11);
		vertexList = graph.getVertexList();
		edgeList = graph.getEdgeList();
		Kosaraju();
		//System.out.println(graph.depthFirstSearch());
		
	}
	
	
	public static void Kosaraju() {
	
		//forward traverse
		System.out.println(depthFirstSearch(1));//update stack as one finishes
		//display stack
		
		System.out.println(displayStack());
		
		
		//transpose
		//reverse traverse
		
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
		
		return depthFirstSearch(0);
	}
	
	public static String depthFirstSearch(int startNode) {
		DFSinit();	
		return DFS(startNode);
	}
	
	
	private static String DFS(int startNode)
	{
		String depthFirst = "";
		StringBuilder sb = new StringBuilder();
		Vertex startVertex = vertexList.get(startNode);
		startVertex.setVisited(true);
		sb.append(startNode);
		
		
		
		for(Vertex child : startVertex.getAdjacentList()) {
			
			
			
			if(child.isVisited()==false) {
					sb.append(DFS(child.getVertexName()));
			}
			
			if(allChildrenVisited(startVertex)) {
				System.out.println("Pushing " + startVertex.getVertexName());
				stack.push(startVertex.getVertexName());
				break;
			}
			
			
				
		}
		
	
		depthFirst = sb.toString();
		return depthFirst;
		
	}

}
