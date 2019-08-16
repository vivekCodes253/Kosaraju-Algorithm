package viv.kosaraju;

import viv.graph.Graph;

public class KosarajuMain {

	public static void main(String[] args) {
		
		//Try dfs first
		
		//1) Create graph 
		
		boolean[][] adjacency =
			{{false,true,true,true},
			{true,false,false,false},
			{true,false,false,false},
			{true,false,false,false}};
		
	
		Graph g = new Graph(adjacency,4);
		
		
		System.out.println(g.getGraphAsString());
		
		

	}

}
