package excercises.codility;

import java.util.ArrayList;

/**
 * Find path from vertex 1 to N for an undirected graph of N vertices and M edges.
 * 
 * -- Image included -- resources/FindPathInGraph.jpg
 * 
 * Uses adjacency_list: An adjacency list is a collection of unordered lists used to represent a finite graph. 
 * Each unordered list within an adjacency list describes the set of neighbors of a particular vertex in the graph.
 * 
 * @author amanuel
 *
 */
public class FindPathInGraph {
	public static void main(String[] args) {

		int[] A = new int[] { 1, 2, 4, 4, 3 };
		int[] B = new int[] { 2, 3, 1, 3, 1 };
//		int[] A = new int[] { 1, 2, 1, 3 };
//		int[] B = new int[] { 2, 15, 3, 4 };
		
		System.out.println(solution(4, A, B));
	}
	
	// build Adjacency-List of an undirected graph
	public static boolean solution (int N, int[] A, int[] B) {
		
		// get size, should be the biggest number in the lists
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] < B[i] && size < B[i]) size = B[i];
			if(size < A[i]) size = A[i];
		}
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= size; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < A.length; i++) {
			adjList.get(A[i]).add(B[i]);
			adjList.get(B[i]).add(A[i]); // remove this if directed graph

		}
		
		// question asks to start from 1 as source and destination N.
		return adjList.get(1).contains(N);
	}

}
