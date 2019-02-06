import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bfs { //Breadth First Search
	
	public static void main(String[] args) {
		FastReader in = new FastReader(); //FastReader class replaces Scanner (gotta go fast)
		
		int n = in.nextInt();
		
		int [][] graph = new int [n][n]; //Adjacency matrix where the node input goes
		for (int ben=0; ben<n; ben++) {
			for (int shapiro=0; shapiro<n; shapiro++) {
				graph[ben][shapiro] = in.nextInt(); //Input
			}
		}
		int [] dist = new int [n]; //Distance array records distance each node is from starting node
		Arrays.fill(dist, Integer.MAX_VALUE); //set all distances to max (so that it can be checked as unvisited)
		
		LinkedList<Path> queue = new LinkedList<Path>(); //Queue holds current node
		
		queue.add(new Path(0,0)); //Add initial node
		
		while(!queue.isEmpty()) { //This is where the fun begins (BFS)
			Path P = queue.pop(); //Check queue for node
			int N = P.node;
			int D = P.distance;
			if (D<dist[N]) { //if distance of current node is less than distance recorded
				dist[N] = D; //set distance to this distance
				for (int i=0; i<n; i++) { //check all possible connections
					if (graph[N][i] == 1) { //if there is 1 connection
						queue.add(new Path(D+1, i)); //add the next node (attached to that connection) to the queue
					}
				}
				if (N == n-1) { //if we are at the final node
					System.out.println(D); //output distance
					return; //yay we did it
				}
			}
		}
		
	}
	static class Path { //path class
		int distance;
		int node;
		Path(int d, int n) {
			distance = d;
			node = n;
		}
	}
	static class FastReader { //FastReader (zoom zoom)
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
