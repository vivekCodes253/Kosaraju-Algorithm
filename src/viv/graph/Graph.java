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
		//Add adjacencies
		vertexList.get(i).addAdjacent(vertexList.get(j));
	}
	
	
	
	public String getGraphAsString(){
		
		String myGraph = null;
		StringBuilder sb = new StringBuilder();
		
		for(Edge edge : edgeList)
			sb.append(edge.getStartVertex().getVertexName()+"->"+edge.getEndVertex().getVertexName()+"\n");
			
		myGraph = sb.toString();
		return myGraph;
		
	}
	
	
	public String getGraphAsCharString(){
		
		String myGraph = null;
		StringBuilder sb = new StringBuilder();
		
		for(Edge edge : edgeList)
			sb.append((char)('a'+edge.getStartVertex().getVertexName())+"->"+(char)('a'+edge.getEndVertex().getVertexName())+"\n");
			
		myGraph = sb.toString();
		return myGraph;
		
	}
		
	private void DFSinit(){
		for(Vertex v : vertexList){
			v.setVisited(false);
		}
	}
	
	public String depthFirstSearch(){
		
		return depthFirstSearch(0);
	}
	
	public String depthFirstSearch(int startNode) {
		DFSinit();	
		return DFS(startNode);
	}
	
	
	private String DFS(int startNode)
	{
		String depthFirst = "";
		StringBuilder sb = new StringBuilder();
		Vertex startVertex = vertexList.get(startNode);
		startVertex.setVisited(true);
		sb.append(startNode);
		//System.out.println(" Entering for "+startNode);
		for(Vertex child : startVertex.getAdjacentList()) {
			if(child.isVisited()==false) {
				//child.setVisited(true);
				//sb.append(child.getVertexName());
				sb.append(DFS(child.getVertexName()));
			}
		}
	
		depthFirst = sb.toString();
		return depthFirst;
		
	}
	
	public void transpose() {
		for(Edge e : edgeList) {
			Vertex tempStart = e.getStartVertex();
			Vertex tempEnd = e.getEndVertex();
			e.setStartVertex(tempEnd);
			e.setEndVertex(tempStart);
			
		}
	}
	
	
	public String alphabetParse(String input) {
		return alphabetParse(input, 'a');
	}
	
	public String alphabetParse(String input,char startingCharacter) {
		StringBuilder sb = new StringBuilder();
		String[] components = input.split(" ");
		
		for(String vertex : components) {
			sb.append((char)(Integer.valueOf(vertex)+'a') + " ");
		}
		
		return sb.toString();
	}



	public List<Vertex> getVertexList() {
		return vertexList;
	}



	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}



	public List<Edge> getEdgeList() {
		return edgeList;
	}



	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
			

	
}
