package viv.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	
	private List<Vertex> vertexList = new ArrayList<>();
	private List<Edge> edgeList =  new ArrayList<>();
	
	public Graph(boolean[][] adjacencyMatrix, int n){
			
		
		int i,j;		
		extractVertexList(n);
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)	
				if(adjacencyMatrix[i][j]==true){
					addEdge(i, j);
				}
	}


		
	public Graph(int[][] adjacencyMatrix, int n){
		
		int i,j;		
		extractVertexList(n);
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)	
				if(adjacencyMatrix[i][j]==1){
					addEdge(i, j);
				}
	}
		
		
	private void extractVertexList(int n) {
		int i;
		for(i=0;i<n;i++){
			Vertex vertex = new Vertex(i);
			vertexList.add(vertex);
		}
	}
	
	
	private void addEdge(int i, int j) {
		Edge edge = new Edge(vertexList.get(i),vertexList.get(j),0);
		edgeList.add(edge);
	}
	
	
	
	public String getGraphAsString(){
		
		String myGraph = null;
		StringBuilder sb = new StringBuilder();
		
		for(Edge edge : edgeList)
			sb.append(edge.getStartVertex().getVertexName()+"->"+edge.getEndVertex().getVertexName()+"\n");
			
		myGraph = sb.toString();
		return myGraph;
		
	}
			
			

	
}
