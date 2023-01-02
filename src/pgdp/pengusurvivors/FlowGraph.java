package pgdp.pengusurvivors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlowGraph {

	private Set<Vertex> vertices;
	private Vertex s;
	private Vertex t;

	public FlowGraph() {
		vertices = new HashSet<>();
	}

	/**
	 * Adds a new Vertex to the FlowGraph and returns the corresponding Object.
	 * 
	 * @return new Vertex
	 */
	public Vertex addVertex() {
		return addVertex("");
	}

	/**
	 * Adds a new Vertex to the FlowGraph and returns the corresponding Object.
	 * 
	 * @param name label of the Vertex
	 * @return new Vertex
	 */
	public Vertex addVertex(String name) {
		Vertex v = new Vertex(name);
		vertices.add(v);
		return v;
	}

	/**
	 * Returns set of all vertices of the graph.
	 * 
	 * @return set of vertices
	 */
	public Set<Vertex> getVertices() {
		return vertices;
	}

	public Vertex getSource() {
		return s;
	}

	public void setSource(Vertex source) {
		s = source;
	}

	public Vertex getSink() {
		return t;
	}

	public void setSink(Vertex target) {
		t = target;
	}

	/**
	 * Computes a correct maximum flow assignment.
	 */
	public void computeMaxFlow() {
		generateResidualGraph();
		List<Vertex> augPath;
		while ((augPath = findPathInResidual()) != null) {
			int augFlow = calcAugmentingFlow(augPath);
			updateNetwork(augPath, augFlow);
		}
	}

	/**
	 * Computes the value of a maximum flow.
	 * 
	 * @return max flow value
	 */
	public int computeMaxFlowValue() {
		// TODO
		return Integer.MIN_VALUE;
	}

	/**
	 * Removes all edges of the residual graph.
	 */
	public void clearResidualGraph() {
		for (Vertex v : vertices) {
			v.residual.clear();
		}
	}

	/**
	 * Generates Edges of the corresponding residual graph.
	 */
	public void generateResidualGraph() {
		clearResidualGraph();
		// TODO
	}

	/**
	 * Returns a path from source to sink (in the residual graph) with positive
	 * capacities. Null if no such path exists.
	 * 
	 * @return s-t path in the residual graph with positive edge capacities.
	 */
	public List<Vertex> findPathInResidual() {
		// TODO
		return null;
	}

	/**
	 * Returns the max. value of an augmenting flow along the given path.
	 * 
	 * @param path s-t-path in the residual network
	 * @return max. value of an augmenting flow along the given path
	 */
	public int calcAugmentingFlow(List<Vertex> path) {
		// TODO
		return Integer.MIN_VALUE;
	}

	/**
	 * Updates the FlowGraph along the specified path by the given flow value.
	 * 
	 * @param path s-t-path in the residual network
	 * @param f    value of the augmenting flow along the given path
	 */
	public void updateNetwork(List<Vertex> path, int f) {
		// TODO
	}

	public static class Vertex {

		private static int id = 0;

		private final String label;
		private HashMap<Vertex, Edge> neighbours;
		private HashMap<Vertex, Edge> residual;

		public Vertex(String name) {
			label = "" + id++ + " - " + name;
			neighbours = new HashMap<>();
			residual = new HashMap<>();
		}

		public void addSingle(Vertex to) {
			addEdge(to, 1);
		}

		public Edge addEdge(Vertex to, int capacity) {
			neighbours.put(to, new Edge(capacity));
			return getEdge(to);
		}

		public Edge addResEdge(Vertex to, int capacity) {
			residual.put(to, new Edge(capacity));
			return getResEdge(to);
		}

		public boolean hasSuccessor(Vertex v) {
			return neighbours.keySet().contains(v);
		}

		public Set<Vertex> getSuccessors() {
			return neighbours.keySet();
		}

		public Set<Vertex> getResSuccessors() {
			return residual.keySet();
		}

		public Edge getEdge(Vertex to) {
			return neighbours.getOrDefault(to, null);
		}

		public Edge getResEdge(Vertex to) {
			return residual.getOrDefault(to, null);
		}

		@Override
		public String toString() {
			return "{ " + label + " : " + neighbours.entrySet().stream().map(entry -> {
				return entry.getKey().label + " - " + entry.getValue().toString();
			}).collect(Collectors.joining(", ")) + " }";
		}
	}

	public static class Edge {

		private int c; // capacity
		private int f; // flow

		/**
		 * Initialize active edge with capacity c=0 and no flow.
		 */
		public Edge() {
			this(0);
		}

		/**
		 * Initialize active edge with capacity c and no flow.
		 * 
		 * @param c capacity of the edge
		 */
		public Edge(int c) {
			this.c = c;
			f = 0;
		}

		public int getFlow() {
			return f;
		}

		public int getCapacity() {
			return c;
		}

		@Override
		public String toString() {
			return "c = " + c + " f = " + f;
		}
	}

}
