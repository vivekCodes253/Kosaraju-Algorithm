package viv.graph;

import java.util.List;

public class Vertex {

	public Vertex(int vertexName) {
		super();
		this.vertexName = vertexName;
	}
	
	private int vertexName;
	private List<Vertex> adjacentList;
	
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
