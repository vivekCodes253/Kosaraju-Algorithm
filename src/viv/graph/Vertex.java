package viv.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	public Vertex(int vertexName) {
		super();
		this.vertexName = vertexName;
	}
	
	private int vertexName;
	private boolean visited;
	private List<Vertex> adjacentList = new ArrayList<>();
	
	public void resetAdjacents() {
		adjacentList = new ArrayList<>();
	}
	
	public boolean hasNoChildren() {
		return adjacentList.size()==0;
	}
	public void addAdjacent(Vertex vertex){
		adjacentList.add(vertex);
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public int getVertexName() {
		return vertexName;
	}
	public void setVertexName(int vertexName) {
		this.vertexName = vertexName;
	}
	public List<Vertex> getAdjacentList() {
		return adjacentList;
	}
	public void setAdjacentList(List<Vertex> adjacentList) {
		this.adjacentList = adjacentList;
	}
	
	
	
	
}
