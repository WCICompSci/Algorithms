import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class dfs { //taken from AQT on dmoj
   
    static int pho[]; //stores restaurants that are pho restaurants
    static ArrayList<Integer> graph[]; //stores tree
    static int par[]; //stores parents of a node
    static int dist[]; //stores distance of a node to root
    static boolean inTree[]; //stores whether or not node is counted or not
   
    static void DFS(int n) { //DFS method
        for(int e : graph[n]) { //for every value in the tree
            if(e != par[n] && inTree[e]) { //if that value does not equal its parent and is counted
                par[e] = n; //the parent of the current value becomes the root
                dist[e] = dist[n] + 1; //the distance of the current value becomes that of the root plus 1
                DFS(e); //dfs is now done on this next node, recursion
            }
        }
    }
   
    public static void main(String []args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()); //input number of restaurants and pho restaurants
        
        pho = new int[M+1]; //initialize pho array
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=M; i++) {
            pho[i] = Integer.parseInt(st.nextToken()); //input pho restaurants
            pho[i]++;
        }
        
        graph = new ArrayList[N+5]; //create tree
        for(int i= 1; i<=N; i++) {
            graph[i] = new ArrayList<>(); //initialize nodes
        }
        
        for(int i = 1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            a++;
            b++;
            graph[a].add(b); //input roads
            graph[b].add(a);
        }
        
        par = new int[N+1]; //initialize arrays
        dist = new int[N+1];
        par[pho[1]] = 0; //the parent of the root node is zero
        inTree = new boolean[N+1];     
        Arrays.fill(inTree, true); //set everything as true
        DFS(pho[1]); //do dfs starting from a root pho node
        
        Arrays.fill(inTree, false); //set everything as false
        
        for(int i = 1; i<=M; i++) { //iterate through pho restaurants
            int crnt = pho[i]; //set current node as current variable
            inTree[crnt] = true; //set true (because we need to traverse the pho restaurants)
            while(!inTree[par[crnt]]) { //while the parent of the tree is not true
                crnt = par[crnt]; //set current variable to its parent (climbing the tree)
                inTree[crnt] = true; //set that current to true
            }
        }
        Arrays.fill(dist, 0); //set all distances back to 0
        Arrays.fill(par, 0); //set all parents back to 0
        DFS(pho[1]); //do dfs again
        
        int endpt = pho[1]; //set the end point to the root
        for(int i = 1; i<=N; i++) {
            endpt = dist[endpt] < dist[i] ? i : endpt; //if the distance of the end point is less than the current 
            //distance, the end point is the current node. otherwise, it remains the same
        }
        Arrays.fill(dist, 0); //set all distances back to 0
        Arrays.fill(par, 0); //set all parents back to 0
        DFS(endpt); //do dfs on the end point
        int dia = 0; //initialize diameter
        for(int i = 1; i<=N; i++) { //iterate through nodes
            dia = Math.max(dia, dist[i]); //diameter is maximum between itself and the current distance
        }
        int cnt = 0; //set count
        for(int i = 1; i<=N; i++) {
            if(inTree[i]) { //for all true nodes
                cnt++; //increase count
            }
        }
        System.out.println(2*(cnt-1) - dia); //output 2 times the count minus the diameter
//        we don't want to return back to the root node
//        the reason why we do 2*(cnt-1) - dia
//        is that
//        cnt-1 is the number of nodes in the new tree
//        2* that because
//        to go from a node and then back
//        it take 2*cnt - 2 time
//        however we don't have have to go back to the starting node
//        so we subtract the longest path
//        because we do not want to go through the longest path twice
    }
}
