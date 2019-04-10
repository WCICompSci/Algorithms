import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
//solution for shortest path

public class dijkstra {
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		
		int n = in.nextInt();
		
		int [][] graph = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				graph[i][j] = in.nextInt();
			}
		}
		int [] dist = new int [n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		LinkedList<Path> queue = new LinkedList<Path>();
		
		queue.add(new Path(0,0));
		
		while(!queue.isEmpty()) {
			Path P = queue.pop();
			int N = P.node;
			int D = P.distance;
			if (D<dist[N]) {
				dist[N] = D;
				for (int i=0; i<n; i++) {
					if (graph[N][i] == 1) {
						queue.add(new Path(D+1, i));
					}
				}
				if (N == n-1) {
					System.out.println(D);
					return;
				}
			}
		}
		
	}
	static class Path {
		int distance;
		int node;
		Path(int d, int n) {
			distance = d;
			node = n;
		}
	}
	static class FastReader {
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
		byte nextByte() {
			return Byte.parseByte(next());
		}
		short nextShort() {
			return Short.parseShort(next());
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		float nextFloat() {
			return Float.parseFloat(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		boolean nextBoolean() {
			return Boolean.parseBoolean(next());
		}
		String nextLine() {
				String str = "";
				try {
					str = br.readLine();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			return str;
		}
		
	}
}
